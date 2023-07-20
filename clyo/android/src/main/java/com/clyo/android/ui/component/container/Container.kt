package com.clyo.android.ui.component.container

import android.view.ViewGroup
import com.clyo.android.ui.component.ViewComponent
import com.clyo.android.ui.component.widget.Widget

class Container<VIEW : ViewGroup>(
    override val view: VIEW,
    content: List<Widget<*, *>>
) : ViewComponent<VIEW> {

    private val _content = content.toMutableList()
    val content: List<Widget<*, *>> get() = _content

    init {
        fun showAllContent() {
            content.forEach(::showWidget)
        }

        showAllContent()
    }

    fun add(widget: Widget<*, *>) {
        _content.add(widget)
        showWidget(widget)
    }

    fun addAll(widgets: List<Widget<*, *>>) {
        widgets.forEach(::add)
    }

    fun remove(widget: Widget<*, *>) {
        _content.remove(widget)
        removeWidget(widget)
    }

    fun removeAll(widgets: List<Widget<*, *>>) {
        widgets.forEach(::remove)
    }

    private fun showWidget(widget: Widget<*, *>) {
        view.addView(widget.view)
    }

    private fun removeWidget(widget: Widget<*, *>) {
        view.removeView(widget.view)
    }
}