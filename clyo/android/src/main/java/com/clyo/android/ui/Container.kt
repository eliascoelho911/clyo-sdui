package com.clyo.android.ui

import android.view.ViewGroup
import com.clyo.data.properties.Properties

abstract class Container<VIEW : ViewGroup>(
    private val widgets: List<Widget<*, *>> = emptyList()
) : ViewComponent<VIEW>() {

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