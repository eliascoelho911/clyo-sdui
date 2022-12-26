package com.clyo.android

import android.content.Context
import android.view.View
import com.clyo.data.ViewData
import com.clyo.global.ClyoApplication
import com.clyo.util.ViewRenderer
import com.clyo.viewbinder.ViewBinderInteractor
import com.clyo.viewbinder.ViewBinderModule
import com.clyo.viewbinder.ViewBinderRegistry
import com.clyo.viewclass.ViewClassInstantiator
import com.clyo.viewclass.ViewClassModule
import com.clyo.viewclass.ViewClassRegistry

internal abstract class ClyoAndroid : ClyoApplication<View>()

internal class ClyoAndroidImpl(
    private val context: Context,
    private val viewBinderRegistry: ViewBinderRegistry = ViewBinderRegistry(),
    private val viewClassRegistry: ViewClassRegistry = ViewClassRegistry()
) : ClyoAndroid() {

    private val viewRenderer: ViewRenderer = ViewRenderer(
        viewClassInstantiator = ViewClassInstantiator(viewClassRegistry.module),
        viewBinderInteractor = ViewBinderInteractor(viewBinderRegistry.module)
    )

    override fun render(data: ViewData): View {
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