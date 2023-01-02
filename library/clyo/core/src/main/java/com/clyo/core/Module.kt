package com.clyo.core

import com.clyo.common.InstanceFactory
import com.clyo.core.tools.ClyoExternalTools.mutableMap

@JvmInline
value class Module<K, V>(
    private val instanceFactories: MutableMap<K, InstanceFactory<V>> = mutableMap()
) {

    fun declare(key: K, value: InstanceFactory<V>) {
        instanceFactories[key] = value
    }

    fun declare(module: Module<K, V>) {
        instanceFactories.putAll(module.instanceFactories)
    }

    fun remove(key: K) {
        instanceFactories.remove(key)
    }

    fun clear() {
        instanceFactories.clear()
    }

    operator fun get(key: K): V {
        return instanceFactories[key]?.invoke() ?: error("Error on get to $key")
    }

    fun getAll(): Map<K, InstanceFactory<V>> = instanceFactories
}

fun <K, V> Collection<Module<K, V>>.singleModule(): Module<K, V> {
    val reference = first()

    forEach {
        if (reference != it) reference.declare(it)
    }

    return reference
}