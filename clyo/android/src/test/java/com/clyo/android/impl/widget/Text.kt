package com.clyo.android.impl.widget

import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.widget.WidgetBinder
import com.clyo.data.properties.Properties
import kotlinx.serialization.Serializable

@Serializable
internal data class TextProperties(
    val text: String
) : Properties()

internal class TextBinder(
    override val widgetId: String
) : WidgetBinder<AppCompatTextView, TextProperties> {

    override fun bind(view: AppCompatTextView, properties: TextProperties) {
        view.text = properties.text
    }
}