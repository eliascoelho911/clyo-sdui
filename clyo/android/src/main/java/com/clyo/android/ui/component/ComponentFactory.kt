package com.clyo.android.ui.component

import android.content.Context
import com.clyo.android.ui.component.container.Container
import com.clyo.android.ui.component.widget.Widget

typealias ContainerFactory = ComponentFactory<out Container<*>>

typealias WidgetFactory = ComponentFactory<out Widget<*, *>>

abstract class ComponentFactory<T : ViewComponent<*>> {
    protected abstract fun provide(type: String): T

    fun create(context: Context, type: String): T {
        return provide(type).also { it.createView(context) }
    }
}