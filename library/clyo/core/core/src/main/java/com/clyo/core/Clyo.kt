package com.clyo.core

object Clyo {
    var engine: ClyoEngine? = null
        private set

    fun start(screenRenderer: AndroidScreenRenderer) {
        engine = ClyoEngine(screenRenderer)
    }

    fun stop() {
        engine = null
    }
}

fun stopClyo() {
    Clyo.stop()
}

fun getClyoEngine(): Lazy<ClyoEngine> = lazy { Clyo.engine ?: error("Clyo is not started") }