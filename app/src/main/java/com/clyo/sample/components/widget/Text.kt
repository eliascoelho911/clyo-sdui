package com.clyo.sample.components.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.component.Widget
import com.clyo.component.widget.WidgetProperties
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("text")
internal data class TextProperties(
    val text: String
) : WidgetProperties()

internal class Text(context: Context) : Widget<AppCompatTextView, TextProperties>() {
    override val view: AppCompatTextView = AppCompatTextView(context)

    override fun bind(properties: TextProperties) {
        view.apply {
            text = properties.text
        }
    }
}