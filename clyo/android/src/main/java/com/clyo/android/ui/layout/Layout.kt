package com.clyo.android.ui.layout

import android.view.ViewGroup
import com.clyo.android.ui.ViewComponent
import com.clyo.android.ui.widget.Widget
import com.clyo.data.properties.PropertiesJson
import com.clyo.data.widget.getProperties

abstract class Layout<VIEW : ViewGroup> : ViewComponent<VIEW>() {
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

    fun render(properties: PropertiesJson) {
        children.forEach { widget ->
            widget.render(properties.getProperties(widget.id))
        }
    }
}