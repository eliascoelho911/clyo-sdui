package com.clyo.ui.dsl

import com.clyo.ui.internal.module.ViewBinderModule

fun viewBinders(block: ViewBinderModule.() -> Unit): ViewBinderModule {
    return ViewBinderModule().apply(block)
}