package com.clyo.android.widget

import android.view.View
import com.clyo.data.properties.Properties

interface WidgetBinder<VIEW : View, PROP : Properties> {
    val widgetId: String

    fun bind(view: VIEW, properties: PROP)
}