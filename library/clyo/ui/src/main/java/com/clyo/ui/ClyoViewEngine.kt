package com.clyo.ui

import android.content.Context
import android.view.View
import com.clyo.data.ViewData
import com.clyo.ui.internal.ViewBinderInteractor
import com.clyo.ui.internal.ViewClassInstantiator
import com.clyo.ui.internal.ViewRenderer
import com.clyo.ui.internal.module.ViewBinderModule
import com.clyo.ui.internal.module.ViewClassModule

internal class ClyoViewEngine {
    private val viewBinderRegistry = ViewBinderRegistry()

    private val viewClassRegistry = ViewClassRegistry()

    private val viewRenderer: ViewRenderer = ViewRenderer(
        viewClassInstantiator = ViewClassInstantiator(viewClassRegistry.module),
        viewBinderInteractor = ViewBinderInteractor(viewBinderRegistry.module)
    )

    fun renderView(context: Context, data: ViewData): View {
        return viewRenderer.render(context, data)
    }

    fun load(vararg modules: ViewBinderModule) {
        load(modules.toList())
    }

    @JvmName("loadViewBinderModules")
    fun load(modules: List<ViewBinderModule>) {
        viewBinderRegistry.loadModules(modules)
    }

    fun load(vararg modules: ViewClassModule) {
        load(modules.toList())
    }

    @JvmName("loadViewClassModules")
    fun load(modules: List<ViewClassModule>) {
        viewClassRegistry.loadModules(modules)
    }
}

internal fun ClyoComponent.renderView(context: Context, data: ViewData): View {
    return clyo.viewEngine.renderView(context, data)
}