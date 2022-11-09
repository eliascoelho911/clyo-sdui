package com.eliascoelho911.clyo.core.component

import kotlin.reflect.KClass

internal class ComponentProviderModule {
    private val _providers = HashMap<KClass<out Component>, ComponentProvider<*>>()
    val providers: Map<KClass<out Component>, ComponentProvider<*>> = _providers

    fun <COMPONENT : Component> associate(
        componentKlass: KClass<COMPONENT>,
        componentProvider: ComponentProvider<COMPONENT>
    ) {
        _providers[componentKlass] = componentProvider
    }

    fun close() {
        _providers.clear()
    }
}