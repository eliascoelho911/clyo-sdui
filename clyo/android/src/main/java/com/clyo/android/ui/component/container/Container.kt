package com.clyo.android.ui.component.container

import android.view.ViewGroup
import com.clyo.android.ui.component.ViewComponent
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.properties.Properties

class Container<VIEW : ViewGroup>(
    override val view: VIEW,
    val content: List<Widget<*, *>>
) : ViewComponent<VIEW> {

    init {
        showContent()
    }

    fun renderContent(properties: (widgetId: String) -> Properties?) {
        content.forEach { widget ->
            properties(widget.id)?.let { widget.render(it) }
        }
    }

    private fun showContent() {
        view.removeAllViews()
        view.addContent()
    }

    private fun ViewGroup.addContent() {
        content.forEach { widget ->
            addView(widget.view)
        }
    }
}