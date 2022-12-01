package com.clyo.core

import android.content.Context
import android.view.ViewGroup
import com.clyo.core.component.Component
import com.clyo.core.component.ComponentModule
import com.clyo.core.component.Container
import com.clyo.core.component.ContainerBuilder
import com.clyo.core.data.ComponentData
import com.clyo.core.data.ComponentName
import com.clyo.core.data.ComponentProperties
import com.clyo.core.data.ContainerData
import com.clyo.core.data.ScreenData

class ClyoEngine(
    private val componentModule: ComponentModule = ComponentModule(),
) {
    fun showScreen(data: ScreenData, parent: ViewGroup) {
        val component = buildComponent(
            context = parent.context,
            data = data.content
        )
        parent.showOnlyComponent(component)
    }

    private fun buildComponent(
        context: Context,
        data: ComponentData
    ): Component<*> = if (data is ContainerData) {
        buildContainer(
            context,
            name = data.name,
            properties = data.properties,
            content = data.content
        )
    } else {
        buildComponent(context, name = data.name, properties = data.properties)
    }

    private fun buildContainer(
        context: Context,
        name: ComponentName,
        properties: ComponentProperties,
        content: List<ComponentData>
    ): Container<*> {
        val builder = componentModule[name] ?: error("ContainerBuilder to $name not found")
        builder as ContainerBuilder<*>
        val componentContent = content.map {
            buildComponent(context, it)
        }
        return builder.withContent(componentContent).build(context, properties)
    }

    private fun buildComponent(
        context: Context,
        name: ComponentName,
        properties: ComponentProperties,
    ): Component<*> {
        val builder = componentModule[name] ?: error("ComponentBuilder to $name not found")
        return builder.build(context, properties)
    }
}

private fun ViewGroup.showOnlyComponent(component: Component<*>) {
    removeAllViews()
    addView(component.view)
}