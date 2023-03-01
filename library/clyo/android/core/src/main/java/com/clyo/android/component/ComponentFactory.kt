package com.clyo.android.component

import android.content.Context
import android.view.View
import com.clyo.android.util.createViewInstance

internal interface ComponentFactory {
    fun create(name: ComponentName): Component<out View>
}

internal class ComponentFactoryImpl(
    private val context: Context,
    private val componentModule: ComponentModule
) : ComponentFactory {
    override fun create(name: ComponentName): Component<out View> {
        val viewKClass = componentModule.getViewKClassOrNull(name)

        requireNotNull(viewKClass)

        return create(name, viewKClass.createViewInstance(context))
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : View> create(name: ComponentName, view: T): Component<T> {
        val viewBinder = componentModule.getComponentBinderOrNull(name)

        requireNotNull(viewBinder)
        viewBinder as ComponentBinder<T>

        return Component(view, viewBinder)
    }
}