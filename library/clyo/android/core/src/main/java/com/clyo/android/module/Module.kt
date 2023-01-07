package com.clyo.android.module

import android.view.View
import com.clyo.android.component.ViewBinder
import com.clyo.android.tools.ClyoExternalTools.safeMutableMapOf
import com.clyo.data.ComponentName
import kotlin.reflect.KClass

class Module {

    private val viewKClasses = safeMutableMapOf<ComponentName, KClass<out View>>()

    private val viewBinders =
        safeMutableMapOf<ComponentName, InstanceFactory<ViewBinder<*>>>()

    fun declare(name: ComponentName, viewKClass: KClass<out View>) {
        viewKClasses[name] = viewKClass
    }

    fun declare(name: ComponentName, viewBinder: InstanceFactory<ViewBinder<*>>) {
        viewBinders[name] = viewBinder
    }

    fun clear() {
        viewKClasses.clear()
        viewBinders.clear()
    }

    fun viewKClass(name: ComponentName): KClass<out View> {
        //TODO Erro
        return viewKClasses[name] ?: error("View class to ${name.name} not found")
    }

    @Suppress("UNCHECKED_CAST")
    fun <T: View> viewBinder(name: ComponentName): ViewBinder<T> {
        //TODO Erro
        val viewBinder =  viewBinders[name]?.invoke() ?: error("ComponentBinder to ${name.name} not found")
        return viewBinder as? ViewBinder<T> ?: error("TODO")
    }
}

fun emptyModule(): Module = Module()