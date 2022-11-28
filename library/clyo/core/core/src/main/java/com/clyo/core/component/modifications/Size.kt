package com.clyo.core.component.modifications

import android.view.ViewGroup.LayoutParams
import com.clyo.core.component.Component
import com.clyo.core.data.ComponentProperties

fun Component.updateSize(properties: ComponentProperties) {
    val width = properties.getIntOrNull("width") ?: LayoutParams.WRAP_CONTENT
    val height = properties.getIntOrNull("height") ?: LayoutParams.WRAP_CONTENT
    layoutParams = LayoutParams(width, height)
}