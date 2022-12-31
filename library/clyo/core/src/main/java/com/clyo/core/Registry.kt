package com.clyo.core

interface Registry<K, V, T : MutableModule<K, V>> {
    val module: T

    fun loadModules(modules: List<T>) {
        modules.forEach { module.declare(it) }
    }
}