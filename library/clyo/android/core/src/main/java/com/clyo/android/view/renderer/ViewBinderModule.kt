package com.clyo.android.view.renderer

import com.clyo.android.ViewName
import com.clyo.core.Module

typealias ViewBinderModule = Module<ViewName, ViewBinder<*>>

fun viewBinders(block: ViewBinderModule.() -> Unit) {
    return ViewBinderModule().block()
}