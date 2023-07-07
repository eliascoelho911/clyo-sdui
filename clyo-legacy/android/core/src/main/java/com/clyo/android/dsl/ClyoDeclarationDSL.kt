package com.clyo.android.dsl

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.clyo.android.ClyoDeclaration
import com.clyo.android.ClyoDeclarationImpl
import com.clyo.android.action.Action
import com.clyo.android.component.ComponentBinder
import com.clyo.android.component.ComponentName
import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.util.ViewProvider
import com.clyo.android.util.ViewProviderWithReflection
import com.clyo.android.util.provideView

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

    fun <T : ViewGroup> container(name: String, provide: (Context) -> T) {
        val viewProvider = provideView(provide)
        component<T>(name, viewProvider)
    }

    @PublishedApi
    internal inline fun <reified T : View> component(
        name: String,
        noinline binder: T.(properties: BasePropertiesData) -> Unit,
    ) {
        val viewProvider = ViewProviderWithReflection(T::class)
        component(name, viewProvider, binder)
    }

    @PublishedApi
    internal fun <T : View> component(
        name: String,
        viewProvider: ViewProvider,
        binder: T.(properties: BasePropertiesData) -> Unit = { }
    ) {
        val componentName = ComponentName(name)

        clyoDeclaration.putViewProvider(componentName, viewProvider)
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