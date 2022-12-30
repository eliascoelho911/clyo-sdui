package com.clyo.android.view

import android.view.View
import com.clyo.data.ViewName
import com.clyo.data.ViewProperties

/**
 * Robô que faz a vinculação de todas as [ViewProperties] em uma [View]
 */
internal class ViewBinderInteractor(
    private val viewBinderModule: ViewBinderModule
) {
    fun <T : View> bind(view: T, name: ViewName, properties: ViewProperties): T {
        val viewBinder = viewBinderModule[name]
        return viewBinder.bind(view, properties)
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : View> ViewBinder<*>.bind(
        view: T,
        properties: ViewProperties
    ): T {
        this as ViewBinder<T>
        return view.also { bind(it, properties) }
    }
}
