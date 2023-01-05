package com.clyo.android

import android.content.Context
import com.clyo.android.component.ComponentFactoryImpl
import com.clyo.android.module.Module
import com.clyo.data.ClyoData

class Clyo internal constructor(context: Context, module: Module) {

    private val componentFactory = ComponentFactoryImpl(context, module)

    fun render(data: ClyoData, container: ClyoView) {
        val root = data.container
        val widget = componentFactory.create(root.name)

        widget.bind(root.properties)

        container.addView(widget.view)
    }
}