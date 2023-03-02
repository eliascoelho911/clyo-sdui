package com.clyo.android.dsl

import android.view.View
import android.view.ViewGroup
import com.clyo.android.ClyoComponents
import com.clyo.android.component.ComponentName

class ClyoComponentsDSL @PublishedApi internal constructor() {

    @PublishedApi
    internal val clyoComponents = ClyoComponents()

    inline fun <reified T : View> widget(
        name: String,
        block: ComponentDeclarationDSL<T>.() -> Unit = {}
    ) {
        component(name, block)
    }

    inline fun <reified T : ViewGroup> container(
        name: String,
        block: ComponentDeclarationDSL<T>.() -> Unit = {}
    ) {
        component(name, block)
    }

    @PublishedApi
    internal inline fun <reified T : View> component(
        name: String,
        block: ComponentDeclarationDSL<T>.() -> Unit
    ) {
        val componentName = ComponentName(name)

        clyoComponents.componentModule.putViewKClass(componentName, T::class)

        ComponentDeclarationDSL<T>(componentName, clyoComponents.componentModule).block()
    }

    fun add(components: ClyoComponents) {
        clyoComponents.componentModule.putAll(components.componentModule)
    }
}

inline fun clyoComponents(scope: ClyoComponentsDSL.() -> Unit): ClyoComponents {
    return ClyoComponentsDSL().apply(scope).clyoComponents
}