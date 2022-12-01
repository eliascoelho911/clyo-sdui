package com.clyo.core.component

import android.view.View
import android.view.ViewGroup
import com.clyo.core.data.ComponentName

//Todo Encontrar uma forma mais performatica de manipular e somar módulos
@JvmInline
value class ComponentModule(
    private val _map: MutableMap<ComponentName, ComponentBuilder<*>> = mutableMapOf()
) {
    fun add(name: ComponentName, builder: ComponentBuilder<*>) {
        _map[name] = builder
    }

    operator fun plus(other: ComponentModule): ComponentModule {
        val map = _map.apply { putAll(other._map) }
        return ComponentModule(map)
    }

    operator fun get(name: ComponentName) = _map[name]

    fun remove(name: ComponentName) {
        _map.remove(name)
    }
}

fun componentModule(
    module: ComponentModule.() -> Unit
) = ComponentModule().apply(module)

fun <T : View> ComponentModule.component(
    name: ComponentName,
    componentBuilder: ComponentBuilder<T>.() -> Unit
) {
    add(
        name = name,
        builder = ComponentBuilder<T>().apply(componentBuilder)
    )
}

fun <T : ViewGroup> ComponentModule.container(
    name: ComponentName,
    containerBuilder: ComponentBuilder<T>.() -> Unit
) {
    add(
        name = name,
        builder = ContainerBuilder<T>().apply(containerBuilder)
    )
}