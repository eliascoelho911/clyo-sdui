package com.clyo.sample.stub

import android.content.Context
import com.clyo.android.ui.component.widget.Widget
import com.clyo.android.ui.component.widget.WidgetProvider
import com.clyo.data.widget.WidgetJson
import com.clyo.sample.components.widget.button
import com.clyo.sample.components.widget.text

internal class WidgetProviderImpl : WidgetProvider {
    override fun provide(context: Context, json: WidgetJson): Widget<*, *> {
        return when (json.type) {
            "text" -> text(context, json.id)
            "button" -> button(context, json.id)
            else -> throw IllegalArgumentException("Unknown widget type: ${json.type}")
        }
    }
}