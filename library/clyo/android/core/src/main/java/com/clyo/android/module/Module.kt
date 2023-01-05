package com.clyo.android.module

import android.view.View
import com.clyo.android.tools.ClyoExternalTools.safeMutableMapOf
import com.clyo.data.ComponentName
import kotlin.reflect.KClass

class Module {

    private val viewKClasses = safeMutableMapOf<ComponentName, KClass<out View>>()

    fun declareView(name: ComponentName, viewKClass: KClass<out View>) {
        viewKClasses[name] = viewKClass
    }

    fun clear() {
        viewKClasses.clear()
    }

    fun viewKClass(name: ComponentName): KClass<out View> {
        //TODO Erro
        return viewKClasses[name] ?: error("View class to ${name.name} not found")
    }
}