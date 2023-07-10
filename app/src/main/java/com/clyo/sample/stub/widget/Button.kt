package com.clyo.sample.stub.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatButton
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.properties.Properties
import com.clyo.data.widget.WidgetJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("button")
internal data class ButtonProperties(
    val text: String,
    val isDisabled: Boolean
) : Properties()

internal class Button(override val id: String = ButtonStubs.widgetJson.id) :
    Widget<AppCompatButton, ButtonProperties>() {

    override fun newViewInstance(context: Context): AppCompatButton {
        return AppCompatButton(context)
    }

    override fun handleProperties(properties: ButtonProperties): AppCompatButton {
        return getView().apply {
            text = properties.text
            isEnabled = !properties.isDisabled
        }
    }
}

internal object ButtonStubs {

    val widgetJsonValue = """
        {
            "type": "button",
            "id": "btn"
        }
    """.trimIndent()
    val widgetJson = WidgetJson(type = "button", id = "btn")

    val propertiesJsonValue = """
        {
            "type": "button",
            "text": "test button",
            "isDisabled": false
        }
    """.trimIndent()
    val properties = ButtonProperties(text = "test button", isDisabled = false)
}