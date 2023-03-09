package com.clyo.android.component.widget.binders

import android.widget.Button
import com.clyo.android.properties.BasePropertiesData

fun Button.applyButtonViewProperties(properties: BasePropertiesData) {
    applyViewProperties(properties)
    applyButtonTextProperty(properties)
}

fun Button.applyButtonTextProperty(properties: BasePropertiesData) {
    properties.getStringOrNull("text")?.let(::setText)
}