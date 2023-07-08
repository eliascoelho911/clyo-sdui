package com.clyo.android.widget

import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.widget.WidgetBinder
import com.clyo.data.properties.PropertiesJson
import com.clyo.data.widget.getProperties
import com.clyo.widget.TextProperties

internal class TextBinder(
    override val widgetId: String
) : WidgetBinder<AppCompatTextView> {
    override fun assign(view: AppCompatTextView, properties: PropertiesJson) {
        val textProperties = properties.getProperties<TextProperties>(widgetId)

        view.text = textProperties.text
    }
}