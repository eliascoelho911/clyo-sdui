package com.clyo.android

import android.content.Context
import com.clyo.android.component.ComponentFactoryImpl
import com.clyo.android.module.Module
import com.clyo.android.util.ClyoRenderer

class Clyo internal constructor(
    private val context: Context,
    private val module: Module,
    private val clyoRenderer: ClyoRenderer = createClyoRenderer(context, module)
) {

    fun render(data: ClyoData, container: ClyoView) {
        clyoRenderer.render(data, container)
    }
}

private fun createClyoRenderer(
    context: Context,
    module: Module
) = ClyoRenderer(ComponentFactoryImpl(context, module))