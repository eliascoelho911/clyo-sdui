package com.eliascoelho911.clyo

import com.eliascoelho911.clyo.component.Component
import com.eliascoelho911.clyo.component.ComponentProvider
import com.eliascoelho911.clyo.component.ComponentProviderModule
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