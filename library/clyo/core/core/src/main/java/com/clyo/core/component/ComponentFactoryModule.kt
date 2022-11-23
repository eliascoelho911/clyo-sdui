package com.clyo.core.component

import com.clyo.core.data.ComponentName
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

object ComponentFactoryModule {
    private val classes: MutableSet<KClass<out ComponentFactory<*>>> = mutableSetOf()

    fun add(classes: Set<KClass<out ComponentFactory<*>>>) {
        ComponentFactoryModule.classes.addAll(classes)
    }

    fun set(classes: Set<KClass<out ComponentFactory<*>>>) {
        ComponentFactoryModule.classes.apply {
            clear()
            addAll(classes)
        }
    }

    operator fun get(name: ComponentName): KClass<out ComponentFactory<*>> {
        return getOrNull(name) ?: error("ComponentFactory of component $name not found")
    }

    fun getOrNull(name: ComponentName): KClass<out ComponentFactory<*>>? = classes.firstOrNull {
        it.findAnnotation<DeclareComponentFactory>()?.name == name
    }
}