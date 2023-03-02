package com.clyo.android.component

import android.view.View
import kotlin.reflect.KClass

interface ComponentModule {
    fun putViewKClass(name: ComponentName, kClass: KClass<out View>)

    fun putBinder(name: ComponentName, binder: () -> ComponentBinder<*>)

    fun putAll(module: ComponentModule)

    fun getViewKClassOrNull(name: ComponentName): KClass<out View>?

    fun getAllViewKClasses(): Map<ComponentName, KClass<out View>>

    fun getBinderOrNull(name: ComponentName): ComponentBinder<*>?

    fun getAllBinders(): Map<ComponentName, () -> ComponentBinder<*>>

    fun clear()
}

internal class ComponentModuleImpl : ComponentModule {

    private val viewKClassesMap = HashMap<ComponentName, KClass<out View>>()

    private val componentBindersMap = HashMap<ComponentName, () -> ComponentBinder<*>>()

    override fun putViewKClass(name: ComponentName, kClass: KClass<out View>) {
        viewKClassesMap[name] = kClass
    }

    override fun putBinder(name: ComponentName, binder: () -> ComponentBinder<*>) {
        componentBindersMap[name] = binder
    }

    override fun putAll(module: ComponentModule) {
        viewKClassesMap.putAll(module.getAllViewKClasses())
        componentBindersMap.putAll(module.getAllBinders())
    }

    override fun getViewKClassOrNull(name: ComponentName): KClass<out View>? {
        return viewKClassesMap[name]
    }

    override fun getAllViewKClasses(): Map<ComponentName, KClass<out View>> {
        return viewKClassesMap
    }

    override fun getBinderOrNull(name: ComponentName): ComponentBinder<*>? {
        return componentBindersMap[name]?.invoke()
    }

    override fun getAllBinders(): Map<ComponentName, () -> ComponentBinder<*>> {
        return componentBindersMap
    }

    override fun clear() {
        componentBindersMap.clear()
        viewKClassesMap.clear()
    }
}

internal fun emptyComponentModule(): ComponentModule = ComponentModuleImpl()