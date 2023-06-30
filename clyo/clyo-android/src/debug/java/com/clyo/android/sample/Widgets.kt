package com.clyo.android.sample

import android.content.Context
import android.widget.TextView
import com.clyo.android.component.ComponentData
import com.clyo.android.component.widget.Widget

class Text(context: Context) : Widget<TextView, TextData>() {
    override val view: TextView = TextView(context)

    override fun render(data: TextData) {
        setText(data.text)
    }

    private fun setText(text: String) {
        applyOnView {
            this.text = text
        }
    }
}

data class TextData(
    val text: String
) : ComponentData