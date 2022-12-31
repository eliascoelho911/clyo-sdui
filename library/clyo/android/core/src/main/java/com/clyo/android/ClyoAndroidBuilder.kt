package com.clyo.android

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.clyo.android.view.AndroidRegistry

//Todo Implementar cache (para evitar processamento desnecessário causado pelo ciclo de vida)
internal fun Activity.findClyoAndroid(): Lazy<ClyoAndroid> = lazy {
    findClyoAndroid(this)
}

internal fun Fragment.findClyoAndroid(): Lazy<ClyoAndroid> = lazy {
    findClyoAndroid(requireContext())
}

private fun findClyoAndroid(context: Context): ClyoAndroid {
    val androidRegistry = AndroidRegistry()

    return findClyoAndroid(context, androidRegistry)
}

private fun findClyoAndroid(
    context: Context,
    androidRegistry: AndroidRegistry,
) = ClyoAndroid(context, androidRegistry)