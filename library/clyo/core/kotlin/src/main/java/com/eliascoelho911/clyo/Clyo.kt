package com.eliascoelho911.clyo

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
}

fun startClyo(screenRenderer: ScreenRenderer) {
    Clyo.start(screenRenderer)
}

fun stopClyo() {
    Clyo.stop()
}

fun getClyoEngine(): ClyoEngine = Clyo.engine ?: error("Clyo is not started")