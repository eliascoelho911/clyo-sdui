package com.clyo.sample.components.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.component.widget.Widget
import com.clyo.android.component.args.ComponentArgs
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("text")
internal data class TextArgs(
    val text: String
) : ComponentArgs()

internal class Text(context: Context) : Widget<AppCompatTextView, TextArgs>() {
    override val view: AppCompatTextView = AppCompatTextView(context)

    override fun updateArgs(args: TextArgs) {
        view.text = args.text
    }
}