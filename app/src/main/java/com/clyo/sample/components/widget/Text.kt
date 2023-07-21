package com.clyo.sample.components.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.widget.WidgetProperties
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("text")
internal data class TextProperties(
    val text: String
) : WidgetProperties()

internal class Text(
    override val view: AppCompatTextView
) : Widget<AppCompatTextView, TextProperties>() {
    override fun applyProperties(view: AppCompatTextView, properties: TextProperties) {
        view.text = properties.text
    }
}

internal fun text(context: Context) = Text(AppCompatTextView(context))