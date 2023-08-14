package com.clyo.sample.presentation.components.widgets

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.component.Widget
import com.clyo.component.widget.WidgetProperties
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("text")
data class TextProperties(
    val text: String,
    val textSize: Float
) : WidgetProperties()

class Text(context: Context) : Widget<AppCompatTextView, TextProperties>() {
    override val view: AppCompatTextView = AppCompatTextView(context)

    override fun bind(properties: TextProperties) {
        view.text = properties.text
        view.textSize = properties.textSize
    }
}