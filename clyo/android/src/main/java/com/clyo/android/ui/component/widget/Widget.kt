package com.clyo.android.ui.component.widget

import android.view.View
import com.clyo.android.ui.component.ViewComponent
import com.clyo.data.widget.WidgetProperties

class Widget<VIEW : View, PROP : WidgetProperties>(
    override val view: VIEW,
    private val binder: WidgetBinder<VIEW, PROP>
) : ViewComponent<VIEW> {
    fun bind(properties: PROP) {
        binder.bind(view, properties)
    }
}