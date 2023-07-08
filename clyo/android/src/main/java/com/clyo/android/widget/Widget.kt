package com.clyo.android.widget

import android.view.View
import com.clyo.data.properties.PropertiesJson

data class Widget<T : View> internal constructor(
    val view: T,
    private val binder: WidgetBinder<T>
) {
    fun render(propertiesJson: PropertiesJson): View {
        binder.assign(view, propertiesJson)

        return view
    }
}