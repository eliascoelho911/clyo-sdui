package com.clyo.ui.dsl

import android.widget.Button
import com.clyo.ui.internal.module.ViewBinderModule

fun viewBinders(block: ViewBinderModule.() -> Unit): ViewBinderModule {
    return ViewBinderModule().apply(block)
}

fun main() {
    viewBinders {
        binder<Button>("Button") {
            text = it.getStringOrNull("text").orEmpty()
        }
    }
}