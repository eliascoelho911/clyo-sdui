package com.clyo.android.ui.component.container

import android.view.ViewGroup
import com.clyo.android.ui.component.ViewComponent
import com.clyo.android.ui.component.widget.Widget

interface ViewGroupContainer<VIEW : ViewGroup> : ViewComponent<VIEW>, Container {

    override val content: List<Widget<*, *>>

    override fun showContent() {
        view.addContent()
    }

    private fun ViewGroup.addContent() {
        content.forEach { widget ->
            addView(widget.view)
        }
    }
}