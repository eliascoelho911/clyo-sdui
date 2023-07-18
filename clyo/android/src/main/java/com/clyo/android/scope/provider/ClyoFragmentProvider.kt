package com.clyo.android.scope.provider

import androidx.annotation.IdRes
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.clyo.android.scope.Clyo
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun Fragment.clyo(@IdRes rootId: Int): ReadOnlyProperty<Fragment, Clyo> =
    ClyoFragmentPropertyDelegate { Clyo(rootView = it.requireView().findViewById(rootId)) }

private class ClyoFragmentPropertyDelegate(
    private val clyoCreator: (Fragment) -> Clyo
) : ReadOnlyProperty<Fragment, Clyo> {

    private var clyo: Clyo? = null
    private val lifecycleObserver = ClyoLifecycleObserver()

    @MainThread
    override fun getValue(thisRef: Fragment, property: KProperty<*>): Clyo {
        thisRef.lifecycle.addObserver(lifecycleObserver)

        return clyo ?: clyoCreator(thisRef).also { clyo = it }
    }

    private inner class ClyoLifecycleObserver : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            clyo = null
        }
    }
}