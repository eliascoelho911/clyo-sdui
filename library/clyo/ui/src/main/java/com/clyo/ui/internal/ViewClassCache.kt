package com.clyo.ui.internal

import android.view.View
import com.clyo.data.ViewName
import kotlin.reflect.KClass

private val viewClassMap = mapOf<ViewName, KClass<out View>>()

/**
 * Essa classe é responsável por armazenar e prover [KClass] da [View] com a key [ViewName]
 */
internal class ViewClassCache {
    //TODO Verificar map mais performático nesse caso
    private val viewClassMap: MutableMap<ViewName, KClass<out View>> = mutableMapOf()

    fun put(viewName: ViewName, clazz: KClass<out View>) {
        viewClassMap[viewName] = clazz
    }

    fun remove(viewName: ViewName) {
        viewClassMap.remove(viewName)
    }

    fun provide(viewName: ViewName): KClass<out View> {
        return viewClassMap[viewName] ?: error("Error on provide ViewClass")
    }
}
