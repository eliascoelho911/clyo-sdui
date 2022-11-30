package com.clyo.core.component.modifications

import android.view.ViewGroup.LayoutParams
import androidx.core.view.updateLayoutParams
import com.clyo.core.component.Component
import com.clyo.core.data.ComponentProperties

fun Component<*>.size(properties: ComponentProperties) {
    val width = properties.getIntOrNull("width") ?: LayoutParams.WRAP_CONTENT
    val height = properties.getIntOrNull("height") ?: LayoutParams.WRAP_CONTENT
    bind {
        if (layoutParams != null) {
            updateLayoutParams {
                this.width = width
                this.height = height
            }
        } else {
            layoutParams = LayoutParams(width, height)
        }
    }
}