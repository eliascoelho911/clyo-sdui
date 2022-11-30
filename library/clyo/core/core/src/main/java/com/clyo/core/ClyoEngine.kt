package com.clyo.core

import android.content.Context
import android.view.ViewGroup
import com.clyo.core.component.Component
import com.clyo.core.component.ComponentModule
import com.clyo.core.data.ComponentData
import com.clyo.core.data.ScreenData

class ClyoEngine(
    private val screenRenderer: ScreenRenderer = ScreenRenderer(),
    componentModule: ComponentModule = ComponentModule()
) {
    private val _componentModule = componentModule

    internal val componentModule get() = _componentModule

    fun showScreen(data: ScreenData, parent: ViewGroup) {
        screenRenderer.render(data, parent)
    }

    fun close() {
        _componentModule.clear()
    }
}

fun <DATA : ComponentData> buildComponent(context: Context, data: DATA): Component<*> =
    Clyo.engine.componentModule.get(context, name = data.name, properties = data.properties)