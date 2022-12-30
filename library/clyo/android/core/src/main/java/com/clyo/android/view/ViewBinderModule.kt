package com.clyo.android.view

import android.view.View
import com.clyo.core.data.WidgetName
import com.clyo.core.data.WidgetProperties
import com.clyo.core.util.InstanceFactory
import com.clyo.core.util.Module

/**
 * Essa classe é responsável por armazenar e prover [ViewBinder] da [View] com a key [WidgetName]
 */
class ViewBinderModule : Module<WidgetName, ViewBinder<*>>() {
    fun <T : View> binder(widgetName: WidgetName, block: T.(properties: WidgetProperties) -> Unit) {
        val binder: InstanceFactory<ViewBinder<*>> = {
            viewBinder(block)
        }
        declare(widgetName, binder)
    }
}
