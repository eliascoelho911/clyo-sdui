package com.clyo.android.widget

import android.view.View
import com.clyo.data.properties.PropertiesJson

interface WidgetBinder<VIEW : View> {
    val widgetId: String

    fun assign(view: VIEW, properties: PropertiesJson)
}