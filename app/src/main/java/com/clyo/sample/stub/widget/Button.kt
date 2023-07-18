package com.clyo.sample.stub.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatButton
import com.clyo.android.ui.component.ComponentRenderer
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.properties.Properties
import com.clyo.data.widget.WidgetJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal fun button(context: Context, id: String): Widget<AppCompatButton, ButtonProperties> {
    return Widget(
        view = AppCompatButton(context),
        id = id,
        renderer = ButtonRenderer()
    )
}

@Serializable
@SerialName("button")
internal data class ButtonProperties(
    val text: String,
    val isEnabled: Boolean
) : Properties()

internal class ButtonRenderer : ComponentRenderer<AppCompatButton, ButtonProperties> {
    override fun render(view: AppCompatButton, properties: ButtonProperties) {
        view.text = properties.text
        view.isEnabled = properties.isEnabled
    }
}

internal object ButtonStubs {

    val widgetJson = WidgetJson(type = "button", id = "btn")

    val propertiesJsonValue = """
        {
            "type": "button",
            "text": "test button",
            "isEnabled": true
        }
    """.trimIndent()
}