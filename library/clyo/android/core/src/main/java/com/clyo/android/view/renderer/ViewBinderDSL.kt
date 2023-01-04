package com.clyo.android.view.renderer

import android.view.View
import com.clyo.core.data.PropertiesData

fun <T : View> viewBinder(block: T.(properties: PropertiesData) -> Unit): ViewBinder<T> =
    object : ViewBinder<T> {
        override fun bind(widget: T, properties: PropertiesData): T {
            return widget.apply { block(properties) }
        }
    }