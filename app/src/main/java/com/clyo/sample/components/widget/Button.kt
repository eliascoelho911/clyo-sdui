package com.clyo.sample.components.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatButton
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.widget.WidgetProperties
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("button")
internal class ButtonProperties(
    val text: String,
    val isEnabled: Boolean
) : WidgetProperties()

internal class Button(
    override val view: AppCompatButton
) : Widget<AppCompatButton, ButtonProperties>() {
    override fun applyProperties(view: AppCompatButton, properties: ButtonProperties) {
        view.text = properties.text
        view.isEnabled = properties.isEnabled
    }
}

internal fun button(context: Context) = Button(AppCompatButton(context))