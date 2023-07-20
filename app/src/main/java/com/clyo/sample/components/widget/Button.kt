package com.clyo.sample.components.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatButton
import com.clyo.android.ui.component.widget.WidgetBinder
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.properties.Properties
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal fun button(context: Context, id: String): Widget<AppCompatButton, ButtonProperties> {
    return Widget(
        view = AppCompatButton(context),
        id = id,
        binder = ButtonBinder()
    )
}

@Serializable
@SerialName("button")
internal data class ButtonProperties(
    val text: String,
    val isEnabled: Boolean
) : Properties()

internal class ButtonBinder : WidgetBinder<AppCompatButton, ButtonProperties> {
    override fun bind(view: AppCompatButton, properties: ButtonProperties) {
        view.text = properties.text
        view.isEnabled = properties.isEnabled
    }
}