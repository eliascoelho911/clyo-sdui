package com.clyo.android.view

import android.view.View
import com.clyo.core.data.WidgetName
import com.clyo.core.data.WidgetProperties
import com.clyo.core.util.Module

class ViewBinderModule : Module<WidgetName, ViewBinder<*>>() {
    fun <T : View> binder(widgetName: WidgetName, block: T.(properties: WidgetProperties) -> Unit) {
        declare(widgetName) { viewBinder(block) }
    }
}
