package com.eliascoelho911.clyo

import com.eliascoelho911.clyo.data.component.ComponentData
import com.eliascoelho911.clyo.data.component.ComponentDataCreator
import kotlin.reflect.KClass

object Clyo {
    private var engine: ClyoEngine? = null

    fun start(block: ClyoEngine.() -> Unit) {
        engine = ClyoEngine().apply(block)
    }

    fun stop() {
        engine?.close()
        engine = null
    }

    fun <COMPONENT : ComponentData> findComponentProvider(
        componentKlass: KClass<COMPONENT>
    ): ComponentDataCreator<COMPONENT>? = engine?.findComponentProvider(componentKlass)
}

fun startClyo(block: ClyoEngine.() -> Unit) {
    Clyo.start(block)
}

fun stopClyo() {
    Clyo.stop()
}

inline fun <reified COMPONENT : ComponentData> findComponentProvider(): ComponentDataCreator<COMPONENT>? =
    Clyo.findComponentProvider(COMPONENT::class)