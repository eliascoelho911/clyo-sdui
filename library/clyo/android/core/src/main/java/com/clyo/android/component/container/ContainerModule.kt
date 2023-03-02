package com.clyo.android.component.container

import android.view.ViewGroup
import com.clyo.android.component.ComponentName
import kotlin.reflect.KClass

interface ContainerModule {
    fun putViewKClass(name: ComponentName, kClass: KClass<out ViewGroup>)

    fun putBinder(name: ComponentName, binder: () -> ContainerBinder<*>)

    fun putAll(module: ContainerModule)

    fun getViewKClassOrNull(name: ComponentName): KClass<out ViewGroup>?

    fun getAllViewKClasses(): Map<ComponentName, KClass<out ViewGroup>>

    fun getBinderOrNull(name: ComponentName): ContainerBinder<*>?

    fun getAllBinders(): Map<ComponentName, () -> ContainerBinder<*>>

    fun clear()
}

internal class ContainerModuleImpl: ContainerModule {

    private val viewKClassesMap = HashMap<ComponentName, KClass<out ViewGroup>>()

    private val componentBindersMap = HashMap<ComponentName, () -> ContainerBinder<*>>()

    override fun putViewKClass(name: ComponentName, kClass: KClass<out ViewGroup>) {
        viewKClassesMap[name] = kClass
    }

    override fun putBinder(name: ComponentName, binder: () -> ContainerBinder<*>) {
        componentBindersMap[name] = binder
    }

    override fun putAll(module: ContainerModule) {
        viewKClassesMap.putAll(module.getAllViewKClasses())
        componentBindersMap.putAll(module.getAllBinders())
    }

    override fun getViewKClassOrNull(name: ComponentName): KClass<out ViewGroup>? {
        return viewKClassesMap[name]
    }

    override fun getAllViewKClasses(): Map<ComponentName, KClass<out ViewGroup>> {
        return viewKClassesMap
    }

    override fun getBinderOrNull(name: ComponentName): ContainerBinder<*>? {
        return componentBindersMap[name]?.invoke()
    }

    override fun getAllBinders(): Map<ComponentName, () -> ContainerBinder<*>> {
        return componentBindersMap
    }

    override fun clear() {
        componentBindersMap.clear()
        viewKClassesMap.clear()
    }
}

fun emptyContainerModule(): ContainerModule = ContainerModuleImpl()