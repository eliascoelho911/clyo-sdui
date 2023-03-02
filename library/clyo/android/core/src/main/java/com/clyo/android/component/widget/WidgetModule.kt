package com.clyo.android.component.widget

import android.view.View
import com.clyo.android.component.ComponentName
import kotlin.reflect.KClass

interface WidgetModule {
    fun putViewKClass(name: ComponentName, kClass: KClass<out View>)

    fun putBinder(name: ComponentName, binder: () -> WidgetBinder<*>)

    fun putAll(module: WidgetModule)

    fun getViewKClassOrNull(name: ComponentName): KClass<out View>?

    fun getAllViewKClasses(): Map<ComponentName, KClass<out View>>

    fun getBinderOrNull(name: ComponentName): WidgetBinder<*>?

    fun getAllBinders(): Map<ComponentName, () -> WidgetBinder<*>>

    fun clear()
}

internal class WidgetModuleImpl: WidgetModule {

    private val viewKClassesMap = HashMap<ComponentName, KClass<out View>>()

    private val componentBindersMap = HashMap<ComponentName, () -> WidgetBinder<*>>()

    override fun putViewKClass(name: ComponentName, kClass: KClass<out View>) {
        viewKClassesMap[name] = kClass
    }

    override fun putBinder(name: ComponentName, binder: () -> WidgetBinder<*>) {
        componentBindersMap[name] = binder
    }

    override fun putAll(module: WidgetModule) {
        viewKClassesMap.putAll(module.getAllViewKClasses())
        componentBindersMap.putAll(module.getAllBinders())
    }

    override fun getViewKClassOrNull(name: ComponentName): KClass<out View>? {
        return viewKClassesMap[name]
    }

    override fun getAllViewKClasses(): Map<ComponentName, KClass<out View>> {
        return viewKClassesMap
    }

    override fun getBinderOrNull(name: ComponentName): WidgetBinder<*>? {
        return componentBindersMap[name]?.invoke()
    }

    override fun getAllBinders(): Map<ComponentName, () -> WidgetBinder<*>> {
        return componentBindersMap
    }

    override fun clear() {
        componentBindersMap.clear()
        viewKClassesMap.clear()
    }
}

fun emptyWidgetModule(): WidgetModule = WidgetModuleImpl()