package com.clyo.android.component.dsl

import android.view.View
import com.clyo.android.component.ComponentModule
import com.clyo.android.component.ComponentName
import com.clyo.android.component.emptyModule
import com.clyo.android.component.widget.dsl.WidgetDeclarationDSL

class ModuleDSL @PublishedApi internal constructor(val componentModule: ComponentModule = emptyModule()) {
    inline fun <reified T : View> component(
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

inline fun clyoModule(scope: ModuleDSL.() -> Unit): ComponentModule {
    return ModuleDSL().apply(scope).componentModule
}