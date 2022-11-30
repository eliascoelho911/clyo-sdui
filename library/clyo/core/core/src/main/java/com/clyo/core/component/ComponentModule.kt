package com.clyo.core.component

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.clyo.core.data.ComponentName
import com.clyo.core.data.ComponentProperties

class ComponentModule(initialModule: Map<ComponentName, ComponentBuilder<*>> = emptyMap()) {
    private val module = HashMap(initialModule)

    fun add(name: ComponentName, builder: ComponentBuilder<*>) {
        module[name] = builder
    }

    operator fun plus(other: ComponentModule): ComponentModule =
        ComponentModule(module + other.module)

    @Suppress("UNCHECKED_CAST")
    fun <COMPONENT : Component<*>> get(
        context: Context,
        name: ComponentName,
        properties: ComponentProperties
    ): COMPONENT {
        val builder = module[name] ?: error("Builder for component $name not found")
        return builder.build(context, properties) as COMPONENT
    }

    fun remove(name: ComponentName) {
        module.remove(name)
    }

    internal fun clear() {
        module.clear()
    }
}

fun componentModule(
    module: ComponentModule.() -> Unit
) = ComponentModule().apply(module)

fun <T : View> ComponentModule.component(
    name: ComponentName,
    componentBuilderBlock: ComponentBuilder<T>.() -> ComponentBuilder<T>
) {
    val componentBuilder = ComponentBuilder<T>().componentBuilderBlock()
    add(name, componentBuilder)
}

fun <T : ViewGroup> ComponentModule.container(
    name: ComponentName,
    content: List<Component<*>>,
    componentBuilderBlock: ComponentBuilder<T>.() -> ComponentBuilder<T>
): Container<T> =
    Container(viewGroup).apply {
        bind(block)
    }