package com.clyo.core.component

import android.content.Context
import android.view.View
import android.view.ViewGroup.LayoutParams
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.core.data.ComponentData
import com.clyo.core.data.ComponentName
import com.clyo.core.data.ComponentProperties
import com.clyo.core.data.LayoutData
import kotlin.reflect.full.createInstance

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class DeclareComponentFactory(val name: ComponentName)

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
                instantiateView(context, currentComponentData)
            }.forEach(::addView)
        }
    }
}

internal fun instantiateView(context: Context, data: ComponentData): View =
    ComponentFactoryModule[data.name].createInstance().create(context, data)

