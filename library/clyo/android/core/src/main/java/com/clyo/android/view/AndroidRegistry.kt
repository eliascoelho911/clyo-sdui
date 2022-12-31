package com.clyo.android.view

class AndroidRegistry(
    val viewBinderModule: ViewBinderModule = ViewBinderModule(),
    val viewClassModule: ViewClassModule = ViewClassModule()
) {
    fun loadViewBinder(modules: Set<ViewBinderModule>) {
        modules.forEach {
            viewBinderModule.declare(it)
        }
    }

    fun loadViewClass(modules: Set<ViewClassModule>) {
        modules.forEach {
            viewClassModule.declare(it)
        }
    }
}