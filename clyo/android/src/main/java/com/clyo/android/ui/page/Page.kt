package com.clyo.android.ui.page

import android.view.ViewGroup
import com.clyo.android.ui.component.container.Container
import com.clyo.data.properties.Properties

class Page internal constructor(private val container: Container<*>) {

    fun attachTo(parent: ViewGroup) {
        parent.removeAllViews()
        parent.addView(container.view)
    }

    fun render(properties: (widgetId: String) -> Properties?) {
        container.renderContent(properties)
    }
}