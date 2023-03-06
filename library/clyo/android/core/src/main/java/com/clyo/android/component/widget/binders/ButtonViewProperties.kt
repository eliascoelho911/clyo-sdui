package com.clyo.android.component.widget.binders

import android.widget.Button
import com.clyo.android.properties.AbstractPropertiesData

fun Button.applyButtonViewProperties(properties: AbstractPropertiesData) {
    applyViewProperties(properties)
    applyButtonTextProperty(properties)
}

fun Button.applyButtonTextProperty(properties: AbstractPropertiesData) {
    properties.getStringOrNull("text")?.let(::setText)
}