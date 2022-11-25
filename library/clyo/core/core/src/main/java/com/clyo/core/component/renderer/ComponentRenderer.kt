package com.clyo.core.component.renderer

import android.content.Context
import android.view.ViewGroup.LayoutParams
import com.clyo.core.component.Component
import com.clyo.core.component.Container
import com.clyo.core.component.Widget
import com.clyo.core.data.ComponentData
import com.clyo.core.data.ContainerData
import com.clyo.core.data.WidgetData

sealed class ComponentRenderer<COMPONENT : Component, DATA : ComponentData> {
    protected abstract val layoutParams: LayoutParams

    fun render(context: Context, data: DATA): COMPONENT = createInstance(context).also {
        bind(it, data)
    }

    protected abstract fun createInstance(context: Context): COMPONENT

    open fun bind(component: COMPONENT, data: DATA) {
        component.apply {
            layoutParams = this@ComponentRenderer.layoutParams
        }
    }
}

abstract class WidgetRenderer<T : Widget> : ComponentRenderer<T, WidgetData>() {
    override val layoutParams: LayoutParams = LayoutParams(
        LayoutParams.WRAP_CONTENT,
        LayoutParams.WRAP_CONTENT
    )
}

abstract class ContainerRenderer<T : Container> : ComponentRenderer<T, ContainerData>() {
    override val layoutParams: LayoutParams = LayoutParams(
        LayoutParams.MATCH_PARENT,
        LayoutParams.MATCH_PARENT
    )

    override fun bind(component: T, data: ContainerData) {
        data.content.map { viewData ->
            findWidgetRenderer(viewData.name).render(component.context, viewData)
        }.forEach { component.addView(it) }
    }
}