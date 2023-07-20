package com.clyo.android.ui.component.widget

import android.view.View
import com.clyo.android.ui.component.ViewComponent
import com.clyo.data.properties.Properties
import com.clyo.data.widget.WidgetProperties

class Widget<VIEW : View, PROP : WidgetProperties>(
    override val view: VIEW,
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