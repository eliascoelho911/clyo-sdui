package com.clyo.android.dsl

import android.view.View
import android.view.ViewGroup
import com.clyo.android.action.Action
import com.clyo.android.component.ClyoDeclarations
import com.clyo.android.component.ClyoDeclarationsImpl
import com.clyo.android.component.ComponentName

class ClyoDeclarationDSL @PublishedApi internal constructor() {

    @PublishedApi
    internal val clyoDeclarations: ClyoDeclarations = ClyoDeclarationsImpl()

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

    fun action(
        name: String,
        action: () -> Action
    ) {
        clyoDeclarations.putAction(name, action)
    }

    @PublishedApi
    internal inline fun <reified T : View> component(
        name: String,
        block: ComponentDeclarationDSL<T>.() -> Unit
    ) {
        val componentName = ComponentName(name)

        clyoDeclarations.putViewKClass(componentName, T::class)

        ComponentDeclarationDSL<T>(componentName, clyoDeclarations).block()
    }

    fun add(declarations: ClyoDeclarations) {
        clyoDeclarations.putAll(declarations)
    }
}

inline fun clyoDeclarations(scope: ClyoDeclarationDSL.() -> Unit): ClyoDeclarations {
    return ClyoDeclarationDSL().apply(scope).clyoDeclarations
}