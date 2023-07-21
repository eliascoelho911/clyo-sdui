package com.clyo.android.ui.component.widget

import android.view.View
import com.clyo.android.ui.component.ViewComponent
import com.clyo.data.widget.WidgetProperties

abstract class Widget<VIEW : View, PROP : WidgetProperties> : ViewComponent<VIEW> {
    abstract fun applyProperties(view: VIEW, properties: PROP)

    @Suppress("UNCHECKED_CAST")
    fun applyProperties(view: VIEW, properties: WidgetProperties) {
        applyProperties(view, properties as PROP)
    }
}

fun <VIEW : View, PROP : WidgetProperties> Widget<VIEW, PROP>.render(properties: WidgetProperties) {
    applyProperties(view, properties)
}