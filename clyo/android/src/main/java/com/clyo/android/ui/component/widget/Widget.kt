package com.clyo.android.ui.component.widget

import android.view.View
import com.clyo.android.ui.component.ComponentRenderer
import com.clyo.android.ui.component.ViewComponent
import com.clyo.data.properties.Properties

class Widget<VIEW : View, PROP : Properties>(
    override val view: VIEW,
    val id: String,
    private val renderer: ComponentRenderer<VIEW, PROP>
) : ViewComponent<VIEW> {

    @Suppress("UNCHECKED_CAST")
    fun render(properties: Properties) {
        renderer.render(
            view = view,
            properties = properties as PROP
        )
    }
}