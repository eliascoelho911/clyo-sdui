package com.clyo.android.ui

import android.view.ViewGroup

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