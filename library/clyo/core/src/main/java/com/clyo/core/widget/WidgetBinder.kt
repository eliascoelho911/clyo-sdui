package com.clyo.core.widget

import com.clyo.core.data.PropertiesData

interface WidgetBinder<Widget> {
    fun bind(widget: Widget, properties: PropertiesData): Widget
}