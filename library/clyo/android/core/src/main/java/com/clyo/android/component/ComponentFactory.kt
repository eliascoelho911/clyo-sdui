package com.clyo.android.component

import android.content.Context
import android.view.View

internal abstract class ComponentFactory {
    protected abstract val componentModule: ComponentModule

    @Suppress("UNCHECKED_CAST")
    protected fun <T : View> getBinder(name: ComponentName): ComponentBinder<T> {
        return getBinderOrEmpty(name) as ComponentBinder<T>
    }

    private fun getBinderOrEmpty(name: ComponentName): ComponentBinder<out View> {
        return componentModule.getBinderOrNull(name) ?: emptyBinder()
    }

    abstract fun create(context: Context, name: ComponentName): Component<out View>

    open fun createAndBind(context: Context, data: AbstractComponentData): Component<out View> {
        return create(context, data.name).also { it.bind(data.properties) }
    }
}

private fun emptyBinder(): ComponentBinder<*> = ComponentBinderImpl<View>()