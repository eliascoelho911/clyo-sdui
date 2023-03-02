package com.clyo.android.component.container

import android.content.Context
import android.view.ViewGroup
import com.clyo.android.component.AbstractComponentData
import com.clyo.android.component.ComponentFactory
import com.clyo.android.component.ComponentModule
import com.clyo.android.component.ComponentName
import com.clyo.android.util.createViewInstance

internal class ContainerFactory(
    override val componentModule: ComponentModule
) : ComponentFactory() {
    override fun create(context: Context, name: ComponentName): Container<*> {
        val viewKClass = componentModule.getViewKClassOrNull(name)
            ?: error("Container $name has not been declared")

        return create(name, viewKClass.createViewInstance(context) as ViewGroup)
    }

    override fun createAndBind(context: Context, data: AbstractComponentData): Container<*> {
        return super.createAndBind(context, data) as Container<*>
    }

    private fun <T : ViewGroup> create(name: ComponentName, viewGroup: T): Container<T> {
        return Container(viewGroup, getBinder(name))
    }
}