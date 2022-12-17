package com.clyo.component.modifications

import android.view.View
import android.view.ViewGroup.LayoutParams
import androidx.core.view.updateLayoutParams
import com.clyo.data.ViewProperties

fun <T : View> T.updateSizeByProperties(properties: ViewProperties) {
    val width = properties.getIntOrNull("width") ?: LayoutParams.WRAP_CONTENT
    val height = properties.getIntOrNull("height") ?: LayoutParams.WRAP_CONTENT
    if (layoutParams != null) {
        updateLayoutParams {
            this.width = width
            this.height = height
        }
    } else {
        layoutParams = LayoutParams(width, height)
    }
}