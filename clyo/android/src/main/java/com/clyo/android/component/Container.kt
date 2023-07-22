package com.clyo.android.component

import android.content.Context
import android.view.ViewGroup
import kotlinx.serialization.Serializable

abstract class Container<V : ViewGroup> : ViewComponent<V> {

    private val _content = mutableListOf<Widget<*, *>>()

    val content: List<Widget<*, *>> get() = _content

    fun add(widget: Widget<*, *>) {
        _content.add(widget)
        view.addView(widget.view)
    }

    fun addAll(widgets: List<Widget<*, *>>) {
        widgets.forEach { add(it) }
    }

    fun remove(index: Int) {
        if (index in 0 until _content.size) {
            _content.removeAt(index).also { view.removeView(it.view) }
        }
    }

    fun clear() {
        _content.clear()
        view.removeAllViews()
    }
}

@Serializable
data class ContainerData(
    @Serializable(with = ComponentTypeSerializer::class)
    val type: ComponentType,
    val content: List<WidgetData>
)

interface ContainerProvider {
    fun provideByType(context: Context, type: ComponentType): Container<*>
}