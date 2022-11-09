package com.eliascoelho911.clyo.core

import com.eliascoelho911.clyo.core.component.Component
import com.eliascoelho911.clyo.core.component.ComponentProvider
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

    fun <COMPONENT : Component> findComponentProvider(
        componentKlass: KClass<COMPONENT>
    ): ComponentProvider<COMPONENT>? = engine?.findComponentProvider(componentKlass)
}

fun startClyo(block: ClyoEngine.() -> Unit) {
    Clyo.start(block)
}

fun stopClyo() {
    Clyo.stop()
}

inline fun <reified COMPONENT : Component> findComponentProvider(): ComponentProvider<COMPONENT>? =
    Clyo.findComponentProvider(COMPONENT::class)