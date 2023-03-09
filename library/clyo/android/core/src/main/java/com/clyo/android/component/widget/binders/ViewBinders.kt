package com.clyo.android.component.widget.binders

import android.view.View
import com.clyo.android.properties.BasePropertiesData

fun View.applyViewProperties(properties: BasePropertiesData) {
    applyBackgroundColorProperty(properties)
}

fun View.applyBackgroundColorProperty(properties: BasePropertiesData) {
    properties.getColorOrNull("background_color")?.let(::setBackgroundColor)
}