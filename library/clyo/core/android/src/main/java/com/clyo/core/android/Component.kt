package com.clyo.core.android

import android.content.Context
import android.view.View
import android.view.ViewGroup.LayoutParams
import androidx.appcompat.widget.LinearLayoutCompat
import com.eliascoelho911.clyo.ComponentData
import com.eliascoelho911.clyo.ComponentProperties
import com.eliascoelho911.clyo.LayoutData

sealed class ComponentFactory<VIEW : View> {
    @Suppress("UNCHECKED_CAST")
    open fun create(context: Context, data: ComponentData): VIEW =
        createInstance(context).apply {
            layoutParams = this@ComponentFactory.layoutParams
            bind(data.properties)
        }

    protected abstract val layoutParams: LayoutParams

    protected abstract fun createInstance(context: Context): VIEW

    protected abstract fun VIEW.bind(properties: ComponentProperties): VIEW
}

abstract class ComponentViewFactory<T : View> : ComponentFactory<T>() {
    override val layoutParams: LayoutParams = LayoutParams(
        LayoutParams.WRAP_CONTENT,
        LayoutParams.WRAP_CONTENT
    )
}

abstract class ContainerFactory : ComponentFactory<LinearLayoutCompat>() {
    override val layoutParams: LayoutParams = LayoutParams(
        LayoutParams.MATCH_PARENT,
        LayoutParams.MATCH_PARENT
    )

    override fun create(context: Context, data: ComponentData): LinearLayoutCompat {
        data as LayoutData
        return super.create(context, data).apply {
            data.content.map { currentComponentData ->
                ComponentFactoryModule
                    .findAndInstantiateByData(currentComponentData)
                    .create(context, currentComponentData)
            }.forEach(::addView)
        }
    }
}