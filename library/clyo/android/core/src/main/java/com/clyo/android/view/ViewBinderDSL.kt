package com.clyo.android.view

import android.view.View
import com.clyo.core.data.WidgetProperties

fun <T : View> viewBinder(block: T.(properties: WidgetProperties) -> Unit): ViewBinder<T> =
    object : ViewBinder<T> {
        override fun bind(view: T, properties: WidgetProperties) {
            view.block(properties)
        }
    }