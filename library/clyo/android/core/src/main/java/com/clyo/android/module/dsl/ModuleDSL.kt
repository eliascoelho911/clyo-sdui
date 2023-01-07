package com.clyo.android.module.dsl

import android.view.View
import com.clyo.android.annotation.ClyoInternalAPI
import com.clyo.android.module.Module
import com.clyo.android.module.emptyModule
import com.clyo.data.ComponentName

@OptIn(ClyoInternalAPI::class)
class ModuleDSL(
    @property:ClyoInternalAPI val module: Module = emptyModule()
) {

    inline fun <reified T : View> component(
        name: String,
        block: ComponentDeclarationDSL<T>.() -> Unit
    ) {
        val componentName = ComponentName(name)

        module.declare(componentName, viewKClass = T::class)

        ComponentDeclarationDSL<T>(componentName, module).block()
    }

    fun add(module: Module) {
        this.module.add(module)
    }
}

@OptIn(ClyoInternalAPI::class)
inline fun clyoModule(scope: ModuleDSL.() -> Unit): Module {
    return ModuleDSL().apply(scope).module
}