package com.clyo.android.view.renderer

import android.view.View
import com.clyo.core.data.ClyoId
import com.clyo.core.data.PropertiesData

/**
 * Robô que faz a vinculação de todas as [PropertiesData] em uma [View]
 */
internal class ViewBinderInteractor(
    private val viewBinderModule: ViewBinderModule
) {
    fun <T : View> bind(view: T, name: ClyoId, properties: PropertiesData): T {
        val viewBinder = viewBinderModule[name]
        return viewBinder.bind(view, properties)
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : View> ViewBinder<*>.bind(
        view: T,
        properties: PropertiesData
    ): T {
        this as ViewBinder<T>
        return bind(view, properties)
    }
}
