package com.clyo.android

import android.content.Context
import android.view.View
import com.clyo.android.view.ViewBinderInteractor
import com.clyo.android.view.ViewBinderModule
import com.clyo.android.view.ViewBinderRegistry
import com.clyo.android.view.ViewClassModule
import com.clyo.android.view.ViewClassRegistry
import com.clyo.android.view.ViewInstantiator
import com.clyo.android.view.ViewRenderer
import com.clyo.core.data.ViewData
import com.clyo.core.global.ClyoApplication

internal abstract class ClyoAndroid : ClyoApplication<View>()

internal class ClyoAndroidImpl(
    private val context: Context,
    private val viewBinderRegistry: ViewBinderRegistry = ViewBinderRegistry(),
    //Todo esse cara é necessário?
    private val viewClassRegistry: ViewClassRegistry = ViewClassRegistry()
) : ClyoAndroid() {

    private val viewRenderer: ViewRenderer = ViewRenderer(
        viewInstantiator = ViewInstantiator(viewClassRegistry.module),
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