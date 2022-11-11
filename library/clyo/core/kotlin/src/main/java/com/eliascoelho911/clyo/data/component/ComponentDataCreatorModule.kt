package com.eliascoelho911.clyo.data.component

import kotlin.reflect.KClass

internal class ComponentDataCreatorModule {
    private val _creators = HashMap<KClass<out ComponentData>, ComponentDataCreator<*>>()

    fun <T : ComponentData> add(
        componentKlass: KClass<T>,
        componentDataCreator: ComponentDataCreator<T>
    ) {
        _creators[componentKlass] = componentDataCreator
    }

    fun addAll(
        map: Map<KClass<out ComponentData>, ComponentDataCreator<*>>
    ) {
        _creators.putAll(map)
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T : ComponentData> get(klassComponent: KClass<T>): ComponentDataCreator<T>? =
        _creators[klassComponent] as ComponentDataCreator<T>?

    fun close() {
        _creators.clear()
    }
}