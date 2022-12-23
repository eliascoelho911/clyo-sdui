package com.clyo.ui.internal.module

typealias InstanceFactory<T> = () -> T

open class Module<K, V> internal constructor(map: Map<K, InstanceFactory<V>> = emptyMap()) {
    private val map: MutableMap<K, InstanceFactory<V>> = map.toMutableMap()

    fun declare(key: K, value: InstanceFactory<V>) {
        map[key] = value
    }

    fun remove(key: K) {
        map.remove(key)
    }

    operator fun get(key: K): V {
        return map[key]?.invoke() ?: error("Error on get to $key")
    }

    operator fun plus(module: Module<K, V>): Module<K, V> {
        return Module(map.plus(module.map))
    }
}