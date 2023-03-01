package com.clyo.android

import android.content.Context
import com.clyo.android.component.ComponentFactoryImpl
import com.clyo.android.component.ComponentModule
import com.clyo.android.koin.ClyoKoinContext

class ClyoEngine internal constructor(
    private val context: Context,
    private val componentModule: ComponentModule,
    private val clyoRenderer: ClyoRenderer = createClyoRenderer(context, componentModule)
) {
    fun init() {
        ClyoKoinContext.initKoin(context)
    }

    fun render(data: ClyoData, container: ClyoView) {
        clyoRenderer.render(data, container)
    }
}

private fun createClyoRenderer(
    context: Context,
    componentModule: ComponentModule
) = ClyoRenderer(ComponentFactoryImpl(context, componentModule))