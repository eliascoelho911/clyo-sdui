package com.clyo.android.view

fun viewBinders(block: ViewBinderModule.() -> Unit) {
    return ViewBinderModule().block()
}