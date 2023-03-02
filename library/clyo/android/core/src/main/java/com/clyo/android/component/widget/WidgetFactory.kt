package com.clyo.android.component.widget

import android.content.Context
import android.view.View
import com.clyo.android.component.AbstractComponentData
import com.clyo.android.component.ComponentFactory
import com.clyo.android.component.ComponentModule
import com.clyo.android.component.ComponentName
import com.clyo.android.util.createViewInstance

internal class WidgetFactory(
    override val componentModule: ComponentModule
) : ComponentFactory() {
    override fun create(context: Context, name: ComponentName): Widget<*> {
        val viewKClass = componentModule.getViewKClassOrNull(name)
            ?: error("Widget $name has not been declared")

        return create(name, viewKClass.createViewInstance(context))
    }

    override fun createAndBind(context: Context, data: AbstractComponentData): Widget<*> {
        return super.createAndBind(context, data) as Widget<*>
    }

    private fun <T : View> create(name: ComponentName, view: T): Widget<T> {
        return Widget(view, getBinder(name))
    }
}