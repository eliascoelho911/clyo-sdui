package com.clyo.sample.stub.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.ui.component.ComponentRenderer
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.properties.Properties
import com.clyo.data.widget.WidgetJson
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