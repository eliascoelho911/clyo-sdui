package com.clyo.android.tools

import android.content.Context
import com.clyo.android.ui.Container
import com.clyo.android.ui.ViewComponent
import com.clyo.android.ui.Widget
import com.clyo.data.container.ContainerJson
import com.clyo.data.widget.WidgetJson

abstract class ContainerFactory(
    private val widgetFactory: WidgetFactory
) : ComponentFactory<Container<*>>() {

    fun create(context: Context, json: ContainerJson): Container<*> {
        return super.create(context, json.type).apply {
            json.content.forEach { widget ->
                add(widgetFactory.create(context, widget))
            }
        }
    }
}

abstract class WidgetFactory : ComponentFactory<Widget<*, *>>() {

    fun create(context: Context, json: WidgetJson): Widget<*, *> {
        return super.create(context, json.type)
    }
}

abstract class ComponentFactory<T : ViewComponent<*>> {
    protected abstract fun provide(type: String): T

    protected fun create(
        context: Context, type: String
    ): T = provide(type).also { it.createView(context) }
}