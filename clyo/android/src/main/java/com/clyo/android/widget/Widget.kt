package com.clyo.android.widget

import android.view.View
import com.clyo.data.properties.Properties

data class Widget<VIEW : View, PROP : Properties> internal constructor(
    val view: VIEW,
    private val binder: WidgetBinder<VIEW, PROP>
) {
    fun render(properties: PROP): View {
        binder.bind(view, properties)

        return view
    }
}