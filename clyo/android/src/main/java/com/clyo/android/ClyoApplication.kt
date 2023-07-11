package com.clyo.android

import com.clyo.android.tools.ClyoTools
import com.clyo.android.tools.ContainerFactory
import kotlinx.serialization.json.Json

internal object ClyoApplication {
    private var tools: ClyoTools? = null

    fun tools(): ClyoTools {
        return tools ?: notInitializedError()
    }

    fun init(tools: ClyoTools) {
        this.tools = tools
    }

    fun stop() {
        tools = null
    }
}

fun startClyo(containerFactory: ContainerFactory, json: Json) {
    ClyoApplication.init(
        tools = ClyoTools(containerFactory, json)
    )
}

fun startClyo() {
    TODO("Implement call to startClyo with generated factories")
}

fun stopClyo() {
    ClyoApplication.stop()
}

private fun notInitializedError(): Nothing {
    throw IllegalStateException("Clyo is not initialized yet")
}