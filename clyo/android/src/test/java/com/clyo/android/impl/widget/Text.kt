package com.clyo.android.impl.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.ui.widget.Widget
import com.clyo.data.properties.Properties
import kotlinx.serialization.Serializable

@Serializable
internal data class TextProperties(
    val text: String
) : Properties()

internal class Text : Widget<AppCompatTextView, TextProperties>() {

    override fun createView(context: Context): AppCompatTextView {
        return AppCompatTextView(context)
    }

    override fun render(properties: TextProperties): AppCompatTextView {
        return getView().apply {
            text = properties.text
        }
    }
}