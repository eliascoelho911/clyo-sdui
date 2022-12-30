package com.clyo.android.view

import android.view.View
import com.clyo.core.data.ViewProperties

fun <T : View> viewBinder(block: T.(properties: ViewProperties) -> Unit): ViewBinder<T> =
    object : ViewBinder<T> {
        override fun bind(view: T, properties: ViewProperties) {
            view.block(properties)
        }
    }