package com.clyo.android.ui.component.widget

import android.view.View
import com.clyo.android.ui.component.ViewComponent
import com.clyo.data.properties.Properties

class Widget<VIEW : View, PROP : Properties>(
    override val view: VIEW,
    val id: String,
    private val binder: WidgetBinder<VIEW, PROP>
) : ViewComponent<VIEW> {

    @Suppress("UNCHECKED_CAST")
    fun bind(properties: Properties) {
        binder.bind(
            view = view,
            properties = properties as PROP
        )
    }
}