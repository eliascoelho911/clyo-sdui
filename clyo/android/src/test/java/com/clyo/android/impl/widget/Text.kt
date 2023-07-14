package com.clyo.android.impl.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.ui.Widget
import com.clyo.data.properties.Properties
import kotlinx.serialization.Serializable

@Serializable
internal data class TextProperties(
    val text: String
) : Properties()

internal class Text(override val id: String = "txt") : Widget<AppCompatTextView, TextProperties>() {

    override fun newViewInstance(context: Context): AppCompatTextView {
        return AppCompatTextView(context)
    }

    override fun render(properties: TextProperties): AppCompatTextView {
        return getView().apply {
            text = properties.text
        }
    }
}