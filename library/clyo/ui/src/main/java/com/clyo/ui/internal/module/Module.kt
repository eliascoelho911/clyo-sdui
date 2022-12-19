package com.clyo.ui.internal.module

typealias InstanceFactory<T> = () -> T

abstract class Module<K, V> {
    private val map: MutableMap<K, InstanceFactory<V>> = mutableMapOf()

    fun declare(key: K, value: InstanceFactory<V>) {
        map[key] = value
    }

    fun remove(key: K) {
        map.remove(key)
    }

    operator fun get(key: K): V {
        return map[key]?.invoke() ?: error("Error on get to $key")
    }
}