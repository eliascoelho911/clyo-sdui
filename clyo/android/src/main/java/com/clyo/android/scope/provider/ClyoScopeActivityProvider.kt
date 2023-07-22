package com.clyo.android.scope.provider

import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.clyo.android.scope.ClyoScope
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun AppCompatActivity.clyo(): ReadOnlyProperty<AppCompatActivity, ClyoScope> =
    ClyoActivityPropertyDelegate { createClyo(this) }

private class ClyoActivityPropertyDelegate(
    private val clyoCreator: (AppCompatActivity) -> ClyoScope
) : ReadOnlyProperty<AppCompatActivity, ClyoScope> {

    private var clyo: ClyoScope? = null
    private val lifecycleObserver = ClyoLifecycleObserver()

    @MainThread
    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): ClyoScope {
        thisRef.lifecycle.addObserver(lifecycleObserver)

        return clyo ?: clyoCreator(thisRef).also { clyo = it }
    }

    private inner class ClyoLifecycleObserver : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            clyo = null
        }
    }
}