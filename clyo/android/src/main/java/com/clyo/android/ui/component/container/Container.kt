package com.clyo.android.ui.component.container

import android.view.ViewGroup
import com.clyo.android.ui.component.ViewComponent
import com.clyo.android.ui.component.widget.Widget

abstract class Container<VIEW : ViewGroup> : ViewComponent<VIEW>() {
    private val _children: MutableList<Widget<*, *>> = mutableListOf()

    val children: List<Widget<*, *>>
        get() = _children

    fun addAll(widgets: List<Widget<*, *>>): ViewGroup {
        widgets.forEach(::add)

        return getView()
    }

    fun add(widget: Widget<*, *>): ViewGroup = applyOnView {
        addView(widget.getView())
        _children.add(widget)
    }
}