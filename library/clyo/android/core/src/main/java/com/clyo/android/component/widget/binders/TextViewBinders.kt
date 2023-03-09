package com.clyo.android.component.widget.binders

import android.widget.TextView
import com.clyo.android.properties.BasePropertiesData

fun TextView.applyTextViewProperties(properties: BasePropertiesData) {
    applyViewProperties(properties)
    applyTextProperty(properties)
}

fun TextView.applyTextProperty(properties: BasePropertiesData) {
    properties.getStringOrNull("text")?.let(::setText)
}