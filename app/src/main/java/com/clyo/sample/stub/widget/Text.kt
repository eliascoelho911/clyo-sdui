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

internal class Text(override val id: String = TextStubs.widgetJson.id) :
    Widget<AppCompatTextView, TextProperties>() {

    override fun newViewInstance(context: Context): AppCompatTextView {
        return AppCompatTextView(context)
    }

    override fun handleProperties(properties: TextProperties): AppCompatTextView {
        return getView().apply {
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