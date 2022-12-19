package com.clyo.ui.internal.cache

internal abstract class LocalCache<K, V> {
    private val map: MutableMap<K, V> = mutableMapOf()

    fun put(key: K, value: V) {
        map[key] = value
    }

    fun remove(key: K) {
        map.remove(key)
    }

    operator fun get(key: K): V {
        return map[key] ?: error("Error on get to $key")
    }
}