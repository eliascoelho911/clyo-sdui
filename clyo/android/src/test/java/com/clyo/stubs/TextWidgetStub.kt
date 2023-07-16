package com.clyo.stubs

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.properties.Properties
import com.clyo.data.widget.WidgetJson
import kotlinx.serialization.Serializable

@Serializable
internal data class TextProperties(
    val text: String
) : Properties()

internal class Text(
    context: Context,
    override val id: String,
    override val view: AppCompatTextView = AppCompatTextView(context)
) : Widget<AppCompatTextView, TextProperties> {

    override fun render(properties: TextProperties): AppCompatTextView {
        return view.apply {
            text = properties.text
        }
    }
}

internal object TextStub {
    val widgetJson = WidgetJson(type = "text", id = "txt")
}