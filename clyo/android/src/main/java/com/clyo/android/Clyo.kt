package com.clyo.android

import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import kotlin.properties.ReadOnlyProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class Clyo internal constructor(lifecycleOwner: LifecycleOwner, private val rootView: ViewGroup) {

    private val lifecycle: Lifecycle = lifecycleOwner.lifecycle
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    init {
        lifecycle.addObserver(ClyoLifecycleObserver())
    }

    fun createPage

    private inner class ClyoLifecycleObserver : DefaultLifecycleObserver {
    }
}


fun AppCompatActivity.clyo(@IdRes rootId: Int): ReadOnlyProperty<AppCompatActivity, Clyo> =
    ReadOnlyProperty { thisRef, _ -> Clyo(thisRef, rootView = findViewById(rootId)) }