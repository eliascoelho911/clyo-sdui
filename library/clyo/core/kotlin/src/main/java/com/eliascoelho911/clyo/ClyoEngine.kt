package com.eliascoelho911.clyo

import com.eliascoelho911.clyo.data.component.ComponentData
import com.eliascoelho911.clyo.data.component.ComponentDataCreator
import com.eliascoelho911.clyo.data.component.ComponentDataCreatorModule
import kotlin.reflect.KClass

class ClyoEngine {
    private var componentDataCreatorModule = ComponentDataCreatorModule()

    fun <COMPONENT : ComponentData> addComponentProvider(
        vararg pair: Pair<KClass<COMPONENT>, ComponentDataCreator<COMPONENT>>,
    ) {
        componentDataCreatorModule.addAll(pair.toMap())
    }

    fun <COMPONENT : ComponentData> findComponentProvider(
        componentKlass: KClass<COMPONENT>
    ): ComponentDataCreator<COMPONENT>? = componentDataCreatorModule[componentKlass]

    fun close() {
        componentDataCreatorModule.close()
    }
}