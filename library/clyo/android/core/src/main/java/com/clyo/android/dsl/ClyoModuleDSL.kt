package com.clyo.android.dsl

import android.view.View
import com.clyo.android.component.ComponentModule
import com.clyo.android.component.ComponentName
import com.clyo.android.component.emptyModule
import com.clyo.android.component.widget.dsl.WidgetDeclarationDSL

class ClyoModuleDSL @PublishedApi internal constructor() {

    @PublishedApi
    internal val componentModule: ComponentModule = emptyModule()

    inline fun <reified T : View> widget(
        name: String,
        block: WidgetDeclarationDSL<T>.() -> Unit
    ) {
        val componentName = ComponentName(name)

        componentModule.putViewKClass(componentName, T::class)

        WidgetDeclarationDSL<T>(componentName, componentModule).block()
    }

    fun add(module: ComponentModule) {
        componentModule.putAll(module)
    }
}

inline fun clyoModule(scope: ClyoModuleDSL.() -> Unit): ComponentModule {
    return ClyoModuleDSL().apply(scope).componentModule
}