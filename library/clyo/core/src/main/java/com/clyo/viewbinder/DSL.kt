package com.clyo.viewbinder

import android.view.View
import com.clyo.data.ViewProperties

fun <T : View> viewBinder(block: T.(properties: ViewProperties) -> Unit): ViewBinder<T> =
    object : ViewBinder<T> {
        override fun bind(view: T, properties: ViewProperties) {
            view.block(properties)
        }
    }