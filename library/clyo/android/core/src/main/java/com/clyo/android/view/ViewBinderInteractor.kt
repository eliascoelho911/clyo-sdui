package com.clyo.android.view

import android.view.View
import com.clyo.core.data.WidgetName
import com.clyo.core.data.WidgetProperties

/**
 * Robô que faz a vinculação de todas as [WidgetProperties] em uma [View]
 */
internal class ViewBinderInteractor(
    private val viewBinderModule: ViewBinderModule
) {
    fun <T : View> bind(view: T, name: WidgetName, properties: WidgetProperties): T {
        val viewBinder = viewBinderModule[name]
        return viewBinder.bind(view, properties)
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : View> ViewBinder<*>.bind(
        view: T,
        properties: WidgetProperties
    ): T {
        this as ViewBinder<T>
        return bind(view, properties)
    }
}
