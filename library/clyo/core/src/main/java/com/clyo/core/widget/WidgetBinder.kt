package com.clyo.core.widget

import com.clyo.core.data.WidgetProperties

interface WidgetBinder<Widget> {
    fun bind(widget: Widget, properties: WidgetProperties): Widget
}