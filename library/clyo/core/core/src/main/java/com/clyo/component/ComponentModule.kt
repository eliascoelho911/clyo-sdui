package com.clyo.component

import android.view.View
import android.view.ViewGroup
import com.clyo.data.ViewName

//Todo Encontrar uma forma mais performatica de manipular e somar módulos
@JvmInline
value class ComponentModule(
    private val _map: MutableMap<ViewName, ComponentBuilder<*>> = mutableMapOf()
) {
    fun add(name: ViewName, builder: ComponentBuilder<*>) {
        _map[name] = builder
    }

    operator fun plus(other: ComponentModule): ComponentModule {
        val map = _map.apply { putAll(other._map) }
        return ComponentModule(map)
    }

    operator fun get(name: ViewName) = _map[name]

    fun remove(name: ViewName) {
        _map.remove(name)
    }
}

fun componentModule(
    module: ComponentModule.() -> Unit
) = ComponentModule().apply(module)

fun <T : View> ComponentModule.component(
    name: ViewName,
    componentBuilder: ComponentBuilder<T>.() -> Unit
) {
    add(
        name = name,
        builder = ComponentBuilder<T>().apply(componentBuilder)
    )
}

fun <T : ViewGroup> ComponentModule.container(
    name: ViewName,
    containerBuilder: ComponentBuilder<T>.() -> Unit
) {
    add(
        name = name,
        builder = ContainerBuilder<T>().apply(containerBuilder)
    )
}