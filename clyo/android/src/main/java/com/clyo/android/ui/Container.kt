package com.clyo.android.ui

import android.view.ViewGroup
import com.clyo.data.properties.Properties

abstract class Container<VIEW : ViewGroup> : ViewComponent<VIEW>() {
    private val _widgets: MutableList<Widget<*, *>> = mutableListOf()

    val widgets: List<Widget<*, *>>
        get() = _widgets

    fun addAllWidgets(widgets: List<Widget<*, *>>) {
        widgets.forEach(::addWidget)
    }

    fun addWidget(widget: Widget<*, *>) {
        _widgets.add(widget)
    }

    fun show() {
        addWidgetsToViewGroup()
    }

    private fun addWidgetsToViewGroup() {
        getView().also { viewGroup ->
            widgets.forEach { widget ->
                viewGroup.addView(widget.getView())
            }
        }
    }
}

fun Container<*>.render(properties: Properties) {
    widgets.forEach { widget ->
        widget.render(properties)
    }
}