package com.clyo.android.component

import android.view.ViewGroup

abstract class Container<V : ViewGroup> : Component<V> {
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