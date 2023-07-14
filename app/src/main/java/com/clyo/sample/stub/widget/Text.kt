package com.clyo.sample.stub.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.ui.Widget
import com.clyo.data.properties.Properties
import com.clyo.data.widget.WidgetJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("text")
internal data class TextProperties(
    val text: String
) : Properties()

internal class Text(
    context: Context,
    override val id: String
) : Widget<AppCompatTextView, TextProperties> {

    override val view: AppCompatTextView = AppCompatTextView(context)

    override fun render(properties: TextProperties): AppCompatTextView {
        return view.apply {
            text = properties.text
        }
    }
}

internal object TextStubs {

    val widgetJsonValue = """
        {
            "type": "text",
            "id": "txt"
        }
    """.trimIndent()
    val widgetJson = WidgetJson(type = "text", id = "txt")

    val propertiesJsonValue = """
        {
            "type": "text",
            "text": "test text"
        }
    """.trimIndent()
    val properties = TextProperties(text = "test text")
}