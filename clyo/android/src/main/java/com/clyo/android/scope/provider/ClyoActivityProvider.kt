package com.clyo.android.scope.provider

import androidx.annotation.IdRes
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.clyo.android.scope.Clyo
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun AppCompatActivity.clyo(@IdRes rootId: Int): ReadOnlyProperty<AppCompatActivity, Clyo> =
    ClyoActivityPropertyDelegate { Clyo(rootView = it.findViewById(rootId)) }

private class ClyoActivityPropertyDelegate(
    private val clyoCreator: (AppCompatActivity) -> Clyo
) : ReadOnlyProperty<AppCompatActivity, Clyo> {

    private var clyo: Clyo? = null
    private val lifecycleObserver = ClyoLifecycleObserver()

    @MainThread
    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): Clyo {
        thisRef.lifecycle.addObserver(lifecycleObserver)

        return clyo ?: clyoCreator(thisRef).also { clyo = it }
    }

    private inner class ClyoLifecycleObserver : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            clyo = null
        }
    }
}