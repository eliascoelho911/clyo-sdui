package com.clyo.android.ui

import android.view.ViewGroup

abstract class Container<VIEW : ViewGroup> : ViewComponent<VIEW> {

    abstract val content: List<Widget<*, *>>

    fun show() {
        addWidgetsToViewGroup()
    }

    private fun addWidgetsToViewGroup() {
        content.forEach { widget ->
            view.addView(widget.view)
        }
    }
}