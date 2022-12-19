package com.clyo.ui.dsl

import android.view.View
import com.clyo.data.ViewProperties
import com.clyo.ui.ViewBinder

fun <T : View> viewBinder(block: T.(properties: ViewProperties) -> Unit): ViewBinder<T> =
    object : ViewBinder<T> {
        override fun bind(view: T, properties: ViewProperties) {
            view.block(properties)
        }
    }