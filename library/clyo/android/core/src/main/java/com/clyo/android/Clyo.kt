package com.clyo.android

import android.content.Context
import com.clyo.android.component.ComponentFactoryImpl
import com.clyo.android.module.Module
import com.clyo.data.ClyoData

class Clyo internal constructor(context: Context, module: Module) {

    private val componentFactory = ComponentFactoryImpl(context, module)

    fun render(data: ClyoData, container: ClyoView) {
        //Todo Exportar todo esse comportamento para outra classe (ClyoRenderer)
        val root = data.container
        val component = componentFactory.create(root.name)

        component.bind(root.properties)

        container.addView(component.view)
    }
}