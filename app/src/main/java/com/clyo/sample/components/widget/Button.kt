package com.clyo.sample.components.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatButton
import com.clyo.android.component.widget.Widget
import com.clyo.android.component.args.ComponentArgs
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("button")
internal data class ButtonArgs(
    val text: String,
    val isEnabled: Boolean
) : ComponentArgs()

internal class Button(context: Context) : Widget<AppCompatButton, ButtonArgs>() {

    override val view: AppCompatButton = AppCompatButton(context)

    override fun updateArgs(args: ButtonArgs) {
        view.text = args.text
        view.isEnabled = args.isEnabled
    }
}