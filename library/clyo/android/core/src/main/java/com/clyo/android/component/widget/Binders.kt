package com.clyo.android.component.widget

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.clyo.android.component.properties.BasePropertiesData

fun Button.applyButtonViewProperties(properties: BasePropertiesData) {
    applyViewProperties(properties)
    applyButtonTextProperty(properties)
}

fun Button.applyButtonTextProperty(properties: BasePropertiesData) {
    properties.getStringOrNull("text")?.let(::setText)
}

fun TextView.applyTextViewProperties(properties: BasePropertiesData) {
    applyViewProperties(properties)
    applyTextProperty(properties)
}

fun TextView.applyTextProperty(properties: BasePropertiesData) {
    properties.getStringOrNull("text")?.let(::setText)
}

fun View.applyViewProperties(properties: BasePropertiesData) {
    applyBackgroundColorProperty(properties)
}

fun View.applyBackgroundColorProperty(properties: BasePropertiesData) {
    properties.getColorOrNull("background_color")?.let(::setBackgroundColor)
}