package com.clyo.android.component.widget

import android.content.Context
import android.view.View
import com.clyo.android.component.Component
import com.clyo.android.component.ComponentFactory
import com.clyo.android.component.ComponentName
import com.clyo.android.util.createViewInstance

internal class WidgetFactory(
    private val widgetModule: WidgetModule
) : ComponentFactory {
    override fun create(context: Context, name: ComponentName): Component<out View> {
        val viewKClass = widgetModule.getViewKClassOrNull(name)

        requireNotNull(viewKClass)

        return create(name, viewKClass.createViewInstance(context))
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : View> create(name: ComponentName, view: T): Component<T> {
        val binder = widgetModule.getBinderOrNull(name)

        requireNotNull(binder)

        binder as WidgetBinder<T>

        return Widget(view, binder)
    }
}