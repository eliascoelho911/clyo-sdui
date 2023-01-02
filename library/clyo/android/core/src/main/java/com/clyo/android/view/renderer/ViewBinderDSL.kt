package com.clyo.android.view.renderer

import android.view.View
import com.clyo.core.data.WidgetProperties

fun <T : View> viewBinder(block: T.(properties: WidgetProperties) -> Unit): ViewBinder<T> =
    object : ViewBinder<T> {
        override fun bind(widget: T, properties: WidgetProperties): T {
            return widget.apply { block(properties) }
        }
    }