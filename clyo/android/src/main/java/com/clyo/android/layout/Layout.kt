package com.clyo.android.layout

import android.view.ViewGroup
import com.clyo.android.widget.Widget

data class Layout<T : ViewGroup> internal constructor(val viewGroup: T) {
    fun add(widget: Widget<*, *>): ViewGroup {
        viewGroup.addView(widget.view)

        return viewGroup
    }

    fun add(widgets: List<Widget<*, *>>): ViewGroup {
        widgets.forEach {
            add(it)
        }

        return viewGroup
    }
}