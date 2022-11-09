package com.eliascoelho911.clyo.core

object Clyo {
    private var engine: ClyoEngine? = null

    fun startClyo(block: ClyoEngine.() -> Unit) {
        engine = ClyoEngine().apply(block)
    }

    fun stopClyo() {
        engine?.close()
        engine = null
    }
}