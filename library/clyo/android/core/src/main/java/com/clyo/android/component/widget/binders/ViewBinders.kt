package com.clyo.android.component.widget.binders

import android.view.View
import com.clyo.android.properties.AbstractPropertiesData

fun View.applyViewProperties(properties: AbstractPropertiesData) {
    applyBackgroundColorProperty(properties)
}

fun View.applyBackgroundColorProperty(properties: AbstractPropertiesData) {
    properties.getColorOrNull("background_color")?.let(::setBackgroundColor)
}