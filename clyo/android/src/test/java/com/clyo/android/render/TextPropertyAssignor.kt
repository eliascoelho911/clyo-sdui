package com.clyo.android.render

import androidx.appcompat.widget.AppCompatTextView
import com.clyo.data.properties.PropertiesJson
import com.clyo.data.widget.getProperties
import com.clyo.widget.TextProperties

internal class TextPropertyAssignor(
    override val widgetId: String
) : WidgetPropertyAssignor<AppCompatTextView, TextProperties> {
    override fun assign(view: AppCompatTextView, properties: PropertiesJson) {
        val textProperties = properties.getProperties<TextProperties>(widgetId)

        view.text = textProperties.text
    }
}