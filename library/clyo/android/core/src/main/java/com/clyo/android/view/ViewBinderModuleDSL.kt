package com.clyo.android.view

fun viewBinders(block: ViewBinderModule.() -> Unit): ViewBinderModule {
    return ViewBinderModule().apply(block)
}