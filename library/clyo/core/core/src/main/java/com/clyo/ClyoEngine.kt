package com.clyo

import android.content.Context
import android.view.ViewGroup
import com.clyo.component.ComponentModule
import com.clyo.component.Container
import com.clyo.component.ContainerBuilder
import com.clyo.data.LayoutData
import com.clyo.data.ScreenData
import com.clyo.data.ViewData
import com.clyo.data.ViewName
import com.clyo.data.ViewProperties

internal class ClyoEngine(
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
        data: ViewData
    ): Component<*> = if (data is LayoutData) {
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
        name: ViewName,
        properties: ViewProperties,
        content: List<ViewData>
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
        name: ViewName,
        properties: ViewProperties,
    ): Component<*> {
        val builder = componentModule[name] ?: error("ComponentBuilder to $name not found")
        return builder.build(context, properties)
    }
}

private fun ViewGroup.showOnlyComponent(component: Component<*>) {
    removeAllViews()
    addView(component.view)
}