package com.clyo.android.component.dsl

import android.view.View
import com.clyo.android.annotation.ClyoInternalAPI
import com.clyo.android.component.ComponentModule
import com.clyo.android.component.ComponentName

@OptIn(ClyoInternalAPI::class)
class ModuleDSL(
    @property:ClyoInternalAPI val componentModule: ComponentModule
) {

    inline fun <reified T : View> component(
        name: String,
        block: ComponentDeclarationDSL<T>.() -> Unit
    ) {
        val componentName = ComponentName(name)

        componentModule.putComponentKClass(componentName, T::class)

        ComponentDeclarationDSL<T>(componentName, componentModule).block()
    }

    fun add(module: ComponentModule) {
        componentModule.putAll(module)
    }
}

@OptIn(ClyoInternalAPI::class)
inline fun clyoModule(scope: ModuleDSL.() -> Unit): ComponentModule {
    val module = TODO()
    return ModuleDSL(module).apply(scope).componentModule
}