package com.clyo.core.util

open class Module<K, V>(map: Map<K, InstanceFactory<V>> = emptyMap()) {
    private val map: HashMap<K, InstanceFactory<V>> = HashMap(map)

    fun declare(key: K, value: InstanceFactory<V>) {
        map[key] = value
    }

    fun declare(module: Module<K, V>) {
        map.putAll(module.map)
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