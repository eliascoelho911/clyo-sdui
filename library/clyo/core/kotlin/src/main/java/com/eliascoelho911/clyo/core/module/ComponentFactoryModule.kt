package com.eliascoelho911.clyo.core.module

import com.eliascoelho911.clyo.core.component.ComponentFactory

class ComponentFactoryModule {
    private val instanceCreator = mutableMapOf<String, () -> ComponentFactory<*>>()

    fun <T : ComponentFactory<*>> add(key: String, instance: () -> T) {
        instanceCreator[key] = instance
    }

    fun findByKey(key: String): ComponentFactory<*>? =
        instanceCreator[key]?.invoke()
}