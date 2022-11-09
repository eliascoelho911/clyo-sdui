package com.eliascoelho911.clyo.core

import com.eliascoelho911.clyo.core.component.Component
import com.eliascoelho911.clyo.core.component.ComponentProvider
import com.eliascoelho911.clyo.core.component.ComponentProviderModule
import kotlin.reflect.KClass

class ClyoEngine {
    private var componentProviderModule = ComponentProviderModule()

    fun <COMPONENT : Component> associate(
        componentKlass: KClass<COMPONENT>,
        componentProvider: ComponentProvider<COMPONENT>
    ) {
        componentProviderModule.associate(componentKlass, componentProvider)
    }

    fun close() {
        componentProviderModule.close()
    }
}