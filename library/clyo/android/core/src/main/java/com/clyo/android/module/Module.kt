package com.clyo.android.module

import android.view.View
import com.clyo.android.component.ViewBinder
import com.clyo.android.tools.ClyoExternalTools.safeMutableMapOf
import com.clyo.data.ComponentName
import kotlin.reflect.KClass

class Module {

    private val viewKClasses = safeMutableMapOf<ComponentName, KClass<out View>>()

    private val viewBinders = safeMutableMapOf<ComponentName, InstanceFactory<ViewBinder<*>>>()

    fun declare(name: ComponentName, viewKClass: KClass<out View>) {
        viewKClasses[name] = viewKClass
    }

    fun declare(name: ComponentName, viewBinder: InstanceFactory<ViewBinder<*>>) {
        viewBinders[name] = viewBinder
    }

    fun add(module: Module) {
        viewKClasses.putAll(module.viewKClasses)
        viewBinders.putAll(module.viewBinders)
    }

    fun clear() {
        viewKClasses.clear()
        viewBinders.clear()
    }

    fun viewKClass(name: ComponentName): KClass<out View> {
        return viewKClasses[name] ?: notFoundError(key = name.name)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : View> viewBinder(name: ComponentName): ViewBinder<T> {
        val viewBinder = viewBinders[name]?.invoke() ?: notFoundError(key = name.name)
        return viewBinder as? ViewBinder<T> ?: incompatibleTypesError()
    }

    private fun notFoundError(key: String): Nothing =
        error("$key not found. Make sure the key exists.")

    private fun incompatibleTypesError(): Nothing =
        error("Incompatible types detected. Make sure that the types being used are compatible.")
}

fun emptyModule(): Module = Module()