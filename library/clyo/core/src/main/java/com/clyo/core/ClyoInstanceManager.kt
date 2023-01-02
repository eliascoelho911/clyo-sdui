package com.clyo.core

import com.clyo.core.annotation.ClyoInternalAPI

@ClyoInternalAPI
object ClyoInstanceManager {
    var application: ClyoApplication? = null
        set(value) {
            application?.stop()
            field = value
        }

    fun stop() {
        application?.stop()
        application = null
    }
}

@OptIn(ClyoInternalAPI::class)
fun stopClyoApplication() {
    ClyoInstanceManager.stop()
}

fun clyoApplication(): Lazy<ClyoApplication> = lazy {
    getClyoApplication()
}

@OptIn(ClyoInternalAPI::class)
fun getClyoApplication(): ClyoApplication {
    return ClyoInstanceManager.application ?: error("Clyo is not started")
}