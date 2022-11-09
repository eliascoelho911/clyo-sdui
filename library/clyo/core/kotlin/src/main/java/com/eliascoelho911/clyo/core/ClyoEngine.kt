package com.eliascoelho911.clyo.core

import com.eliascoelho911.clyo.core.component.Component
import com.eliascoelho911.clyo.core.component.ComponentProvider
import com.eliascoelho911.clyo.core.component.ComponentProviderModule
import kotlin.reflect.KClass

class ClyoEngine {
    private var componentProviderModule = ComponentProviderModule()

    fun <COMPONENT : Component> addComponentProvider(
        vararg pair: Pair<KClass<COMPONENT>, ComponentProvider<COMPONENT>>,
    ) {
        componentProviderModule.addAll(pair.toMap())
    }

    fun <COMPONENT : Component> findComponentProvider(
        componentKlass: KClass<COMPONENT>
    ): ComponentProvider<COMPONENT>? = componentProviderModule[componentKlass]

    fun close() {
        componentProviderModule.close()
    }
}