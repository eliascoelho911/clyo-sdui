package com.clyo.sample.components.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.ui.component.ComponentRenderer
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.properties.Properties
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal fun text(context: Context, id: String): Widget<AppCompatTextView, TextProperties> {
    return Widget(
        view = AppCompatTextView(context),
        id = id,
        renderer = TextRenderer()
    )
}

@Serializable
@SerialName("text")
internal data class TextProperties(
    val text: String
) : Properties()

internal class TextRenderer : ComponentRenderer<AppCompatTextView, TextProperties> {
    override fun render(view: AppCompatTextView, properties: TextProperties) {
        view.text = properties.text
    }
}