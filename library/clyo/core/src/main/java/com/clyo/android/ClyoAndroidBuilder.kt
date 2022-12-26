package com.clyo.android

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.clyo.viewbinder.ViewBinderRegistry
import com.clyo.viewclass.ViewClassRegistry

//Todo Implementar cache (para evitar processamento desnecessário causado pelo ciclo de vida)
internal fun Activity.findClyoAndroid(): Lazy<ClyoAndroid> = lazy {
    findClyoAndroid(this)
}

internal fun Fragment.findClyoAndroid(): Lazy<ClyoAndroid> = lazy {
    findClyoAndroid(requireContext())
}

private fun findClyoAndroid(context: Context): ClyoAndroid {
    val viewBinderRegistry = ViewBinderRegistry()
    val viewClassRegistry = ViewClassRegistry()

    return findClyoAndroid(context, viewBinderRegistry, viewClassRegistry)
}

private fun findClyoAndroid(
    context: Context,
    viewBinderRegistry: ViewBinderRegistry,
    viewClassRegistry: ViewClassRegistry
) = ClyoAndroidImpl(context, viewBinderRegistry, viewClassRegistry)