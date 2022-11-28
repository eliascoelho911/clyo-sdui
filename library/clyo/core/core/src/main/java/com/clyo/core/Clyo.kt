package com.clyo.core

import com.clyo.core.component.ComponentModule

object Clyo {
    private var mEngine: ClyoEngine? = null

    val engine: ClyoEngine
        get() {
            if (mEngine == null) notStartedError()
            return mEngine!!
        }

    fun start(componentModule: ComponentModule = ComponentModule()) {
        mEngine = ClyoEngine(componentModule = componentModule)
    }

    //TODO Deve parar sincronizado com o ciclo de vida da Activity
    fun stop() {
        mEngine?.close()
        mEngine = null
    }

    private fun notStartedError() {
        error("Clyo is not started")
    }
}

fun startClyo(componentModule: ComponentModule = ComponentModule()) {
    Clyo.start(componentModule)
}

fun stopClyo() {
    Clyo.stop()
}

fun getClyoEngine(): Lazy<ClyoEngine> = lazy { Clyo.engine }