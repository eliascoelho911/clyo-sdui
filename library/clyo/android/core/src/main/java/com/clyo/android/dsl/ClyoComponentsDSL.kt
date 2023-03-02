package com.clyo.android.dsl

import android.view.View
import com.clyo.android.ClyoComponents
import com.clyo.android.component.ComponentName
import com.clyo.android.component.widget.dsl.WidgetDeclarationDSL

class ClyoComponentsDSL @PublishedApi internal constructor() {

    @PublishedApi
    internal val clyoComponents = ClyoComponents()

    inline fun <reified T : View> widget(
        name: String,
        block: WidgetDeclarationDSL<T>.() -> Unit
    ) {
        val componentName = ComponentName(name)

        clyoComponents.widgetModule.putViewKClass(componentName, T::class)

        WidgetDeclarationDSL<T>(componentName, clyoComponents.widgetModule).block()
    }

    fun add(components: ClyoComponents) {
        clyoComponents.widgetModule.putAll(components.widgetModule)
    }
}

inline fun clyoComponents(scope: ClyoComponentsDSL.() -> Unit): ClyoComponents {
    return ClyoComponentsDSL().apply(scope).clyoComponents
}