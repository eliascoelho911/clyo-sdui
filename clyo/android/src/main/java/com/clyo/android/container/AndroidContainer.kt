package com.clyo.android.container

import android.view.ViewGroup
import com.clyo.android.widget.AndroidWidget
import com.clyo.component.Container

abstract class AndroidContainer<V : ViewGroup> : Container<V, AndroidWidget<*, *>> {

    private val _content = mutableListOf<AndroidWidget<*, *>>()

    override val content: List<AndroidWidget<*, *>> get() = _content

    override fun add(widget: AndroidWidget<*, *>) {
        _content.add(widget)
        value.addView(widget.value)
    }

    override fun addAll(widgets: List<AndroidWidget<*, *>>) {
        widgets.forEach { add(it) }
    }

    override fun remove(index: Int) {
        if (index in 0 until _content.size) {
            _content.removeAt(index).also { value.removeView(it.value) }
        }
    }

    override fun clear() {
        _content.clear()
        value.removeAllViews()
    }
}