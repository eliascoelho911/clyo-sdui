package com.clyo.android.scope.provider

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.clyo.android.scope.ClyoScope
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun Fragment.clyo(): ReadOnlyProperty<Fragment, ClyoScope> =
    ClyoFragmentPropertyDelegate { createClyo(requireContext()) }

private class ClyoFragmentPropertyDelegate(
    private val clyoCreator: (Fragment) -> ClyoScope
) : ReadOnlyProperty<Fragment, ClyoScope> {

    private var clyo: ClyoScope? = null
    private val lifecycleObserver = ClyoLifecycleObserver()

    @MainThread
    override fun getValue(thisRef: Fragment, property: KProperty<*>): ClyoScope {
        thisRef.lifecycle.addObserver(lifecycleObserver)

        return clyo ?: clyoCreator(thisRef).also { clyo = it }
    }

    private inner class ClyoLifecycleObserver : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            clyo = null
        }
    }
}