package com.clyo.core.tools

import com.clyo.core.ClyoId
import java.util.UUID

internal object ClyoExternalTools {
    fun <K, V> mutableMap(initialContent: Map<K, V> = emptyMap()): MutableMap<K, V> =
        HashMap(initialContent)

    fun generateClyoId(): ClyoId = UUID.randomUUID().toString()
}

