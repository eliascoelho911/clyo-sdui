package com.clyo.android.dsl

import android.view.View
import android.view.ViewGroup
import com.clyo.android.ClyoDeclaration
import com.clyo.android.ClyoDeclarationImpl
import com.clyo.android.action.Action
import com.clyo.android.component.ComponentBinder
import com.clyo.android.component.ComponentName
import com.clyo.android.component.properties.BasePropertiesData
import kotlin.reflect.KClass

class ClyoDeclarationDSL @PublishedApi internal constructor() {

    @PublishedApi
    internal val clyoDeclaration: ClyoDeclaration = ClyoDeclarationImpl()

    inline fun <reified T : View> widget(
        name: String,
        noinline binder: T.(properties: BasePropertiesData) -> Unit = {}
    ) {
        component(name, binder)
    }

    inline fun <reified T : ViewGroup> container(
        name: String,
        noinline binder: T.(properties: BasePropertiesData) -> Unit = {}
    ) {
        component(name, binder)
    }

    fun <T : ViewGroup> container(name: String, viewKClass: KClass<T>) {
        component(name, viewKClass)
    }

    @PublishedApi
    internal inline fun <reified T : View> component(
        name: String,
        noinline binder: T.(properties: BasePropertiesData) -> Unit,
    ) {
        component(name, T::class, binder)
    }

    @PublishedApi
    internal fun <T : View> component(
        name: String,
        viewKClass: KClass<T>,
        binder: T.(properties: BasePropertiesData) -> Unit = { }
    ) {
        val componentName = ComponentName(name)

        clyoDeclaration.putViewKClass(componentName, viewKClass)
        clyoDeclaration.putBinder(componentName) { ComponentBinder(binder) }
    }

    fun action(
        name: String,
        action: () -> Action
    ) {
        clyoDeclaration.putAction(name, action)
    }

    fun add(declarations: ClyoDeclaration) {
        clyoDeclaration.putAll(declarations)
    }
}

inline fun clyoDeclaration(scope: ClyoDeclarationDSL.() -> Unit): ClyoDeclaration {
    return ClyoDeclarationDSL().apply(scope).clyoDeclaration
}