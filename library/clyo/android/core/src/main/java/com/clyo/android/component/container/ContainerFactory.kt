package com.clyo.android.component.container

import android.content.Context
import android.view.ViewGroup
import com.clyo.android.component.ComponentFactory
import com.clyo.android.component.ComponentName
import com.clyo.android.util.createViewInstance

internal class ContainerFactory(
    private val containerModule: ContainerModule
) : ComponentFactory {
    override fun create(context: Context, name: ComponentName): Container<*> {
        val viewKClass = containerModule.getViewKClassOrNull(name)

        requireNotNull(viewKClass)

        return create(name, viewKClass.createViewInstance(context))
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : ViewGroup> create(name: ComponentName, viewGroup: T): Container<T> {
        val binder = containerModule.getBinderOrNull(name)

        requireNotNull(binder)

        binder as ContainerBinder<T>

        return Container(viewGroup, binder)
    }
}