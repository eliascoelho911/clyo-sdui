package com.clyo.android.component.widget.binders

import android.widget.TextView
import com.clyo.android.properties.AbstractPropertiesData

fun TextView.applyTextViewProperties(properties: AbstractPropertiesData) {
    applyViewProperties(properties)
    applyTextProperty(properties)
}

fun TextView.applyTextProperty(properties: AbstractPropertiesData) {
    properties.getStringOrNull("text")?.let(::setText)
}