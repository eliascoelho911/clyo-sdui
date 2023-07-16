package com.clyo.android.ui.component.widget

import android.view.View
import com.clyo.android.ui.component.ViewComponent
import com.clyo.data.properties.Properties

interface Widget<VIEW : View, PROP : Properties> : ViewComponent<VIEW> {

    val id: String

    /**
     * This method is responsible for rendering the widget, adding the properties to it.
     */
    fun render(properties: PROP): VIEW

    @Suppress("UNCHECKED_CAST")
    @Deprecated(
        replaceWith = ReplaceWith("render(properties)"),
        message = "Use render(properties) instead"
    )
    fun render(properties: Properties) {
        render(
            properties as? PROP ?: throw IllegalArgumentException("Properties type mismatch")
        )
    }
}