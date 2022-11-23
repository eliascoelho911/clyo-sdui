package com.clyo.core.android

import com.clyo.core.android.annotation.DeclareComponentFactory
import com.eliascoelho911.clyo.ComponentData
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation

object ComponentFactoryModule {
    private val classes: MutableSet<KClass<out ComponentFactory<*>>> = mutableSetOf()

    fun add(classes: Set<KClass<out ComponentFactory<*>>>) {
        this.classes.addAll(classes)
    }

    fun set(classes: Set<KClass<out ComponentFactory<*>>>) {
        this.classes.apply {
            clear()
            addAll(classes)
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun findAndInstantiateByData(data: ComponentData): ComponentFactory<*> =
        classes.firstOrNull {
            it.findAnnotation<DeclareComponentFactory>()?.name == data.name
        }?.createInstance() ?: error("component factory não encontrado")
}