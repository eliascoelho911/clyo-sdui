package com.clyo.android.component

import android.view.View
import com.clyo.android.action.Action
import kotlin.reflect.KClass

interface ClyoDeclarations {
    fun putViewKClass(name: ComponentName, kClass: KClass<out View>)

    fun putBinder(name: ComponentName, binder: () -> ComponentBinder<*>)

    fun putAction(name: String, action: () -> Action)

    fun putAll(module: ClyoDeclarations)

    fun getViewKClassOrNull(name: ComponentName): KClass<out View>?

    fun getAllViewKClasses(): Map<ComponentName, KClass<out View>>

    fun getBinderOrNull(name: ComponentName): ComponentBinder<*>?

    fun getAllBinders(): Map<ComponentName, () -> ComponentBinder<*>>

    fun getActionOrNull(name: String): Action?

    fun getAllActions(): Map<String, () -> Action>

    fun clear()
}

internal class ClyoDeclarationsImpl : ClyoDeclarations {

    private val viewKClassesMap = HashMap<ComponentName, KClass<out View>>()

    private val componentBindersMap = HashMap<ComponentName, () -> ComponentBinder<*>>()

    private val actionsMap = HashMap<String, () -> Action>()

    override fun putViewKClass(name: ComponentName, kClass: KClass<out View>) {
        viewKClassesMap[name] = kClass
    }

    override fun putBinder(name: ComponentName, binder: () -> ComponentBinder<*>) {
        componentBindersMap[name] = binder
    }

    override fun putAction(name: String, action: () -> Action) {
        actionsMap[name] = action
    }

    override fun putAll(module: ClyoDeclarations) {
        viewKClassesMap.putAll(module.getAllViewKClasses())
        componentBindersMap.putAll(module.getAllBinders())
        actionsMap.putAll(module.getAllActions())
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

    override fun getActionOrNull(name: String): Action? {
        return actionsMap[name]?.invoke()
    }

    override fun getAllActions(): Map<String, () -> Action> {
        return actionsMap
    }

    override fun clear() {
        componentBindersMap.clear()
        viewKClassesMap.clear()
    }
}

internal fun emptyClyoDeclarations(): ClyoDeclarations = ClyoDeclarationsImpl()