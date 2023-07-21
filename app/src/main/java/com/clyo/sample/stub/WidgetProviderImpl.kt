package com.clyo.sample.stub

import android.content.Context
import com.clyo.android.ui.component.widget.Widget
import com.clyo.android.ui.component.widget.WidgetProvider
import com.clyo.sample.components.widget.button
import com.clyo.sample.components.widget.text

internal class WidgetProviderImpl : WidgetProvider {
    override fun provide(context: Context, type: String): Widget<*, *> {
        return when (type) {
            "text" -> text(context)
            "button" -> button(context)
            else -> throw IllegalArgumentException("Unknown widget type: $type")
        }
    }
}