package com.clyo.ui.internal

import android.view.View
import com.clyo.data.ViewName
import com.clyo.data.ViewProperties
import com.clyo.ui.ViewBinder
import com.clyo.ui.internal.module.ViewBinderModule

/**
 * Robô que faz a vinculação de todas as [ViewProperties] em uma [View]
 */
internal class ViewBinderRobot(
    private val viewBinderCache: ViewBinderModule
) {
    fun <T : View> bind(view: T, name: ViewName, properties: ViewProperties): T {
        val viewBinder = viewBinderCache[name]
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
