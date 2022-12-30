package com.clyo.core.util

abstract class Registry<K, V, T : Module<K, V>> {
    abstract val module: T

    fun loadModules(modules: List<T>) {
        modules.forEach { module.declare(it) }
    }
}