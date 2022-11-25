package com.clyo.core

object Clyo {
    private var mEngine: ClyoEngine? = null

    val engine: ClyoEngine
        get() {
            if (mEngine == null) notStartedError()
            return mEngine!!
        }

    fun start(screenRenderer: ScreenRenderer) {
        mEngine = ClyoEngine(screenRenderer)
    }

    fun stop() {
        mEngine?.close()
        mEngine = null
    }

    private fun notStartedError() {
        error("Clyo is not started")
    }
}

fun getClyoEngine(): Lazy<ClyoEngine> = lazy { Clyo.engine }