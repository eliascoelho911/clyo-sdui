package com.clyo.viewbinder

fun viewBinders(block: ViewBinderModule.() -> Unit): ViewBinderModule {
    return ViewBinderModule().apply(block)
}