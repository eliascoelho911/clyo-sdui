package com.eliascoelho911.clyo

import com.eliascoelho911.clyo.data.component.ComponentData
import com.eliascoelho911.clyo.data.component.ComponentDataCreator
import kotlin.reflect.KClass

object Clyo {
    var engine: ClyoEngine? = null
        private set

    fun start(screenRenderer: ScreenRenderer) {
        engine = ClyoEngine(screenRenderer)
    }

    fun stop() {
        engine?.close()
        engine = null
    }

    fun <COMPONENT : ComponentData> findComponentProvider(
        componentKlass: KClass<COMPONENT>
    ): ComponentDataCreator<COMPONENT>? = engine?.findComponentProvider(componentKlass)
}

fun startClyo(screenRenderer: ScreenRenderer) {
    Clyo.start(screenRenderer)
}

fun stopClyo() {
    Clyo.stop()
}

fun getClyoEngine(): ClyoEngine = Clyo.engine ?: error("Clyo is not started")

inline fun <reified COMPONENT : ComponentData> findComponentProvider(): ComponentDataCreator<COMPONENT>? =
    Clyo.findComponentProvider(COMPONENT::class)