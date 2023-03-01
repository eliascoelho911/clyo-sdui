package com.clyo.android.component

import android.view.View
import kotlin.reflect.KClass

interface ComponentModule {
    fun putComponentKClass(name: ComponentName, kClass: KClass<out View>)

    fun putComponentBinder(name: ComponentName, binder: () -> ComponentBinder<*>)

    fun putAll(module: ComponentModule)

    fun getComponentKClassOrNull(name: ComponentName): KClass<out View>

    fun getComponentBinder(name: ComponentName): ComponentBinder<*>

    fun clear()
}