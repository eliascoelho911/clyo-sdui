package com.eliascoelho911.clyo.component

import kotlin.reflect.KClass

internal class ComponentProviderModule {
    private val _providers = HashMap<KClass<out Component>, ComponentProvider<*>>()

    fun <T : Component> add(
        componentKlass: KClass<T>,
        componentProvider: ComponentProvider<T>
    ) {
        _providers[componentKlass] = componentProvider
    }

    fun addAll(
        map: Map<KClass<out Component>, ComponentProvider<*>>
    ) {
        _providers.putAll(map)
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T : Component> get(klassComponent: KClass<T>): ComponentProvider<T>? =
        _providers[klassComponent] as ComponentProvider<T>?

    fun close() {
        _providers.clear()
    }
}