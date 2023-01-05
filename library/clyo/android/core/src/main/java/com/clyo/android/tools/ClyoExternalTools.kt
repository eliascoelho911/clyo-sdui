package com.clyo.android.tools

internal object ClyoExternalTools {
    fun <K, V> safeMutableMapOf(initialContent: Map<K, V> = emptyMap()): MutableMap<K, V> =
        HashMap(initialContent)
}

