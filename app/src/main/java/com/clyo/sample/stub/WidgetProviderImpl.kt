package com.clyo.sample.stub

import com.clyo.android.tools.WidgetProvider
import com.clyo.android.ui.Widget
import com.clyo.sample.stub.widget.Button
import com.clyo.sample.stub.widget.ButtonStubs
import com.clyo.sample.stub.widget.Text
import com.clyo.sample.stub.widget.TextStubs

internal class WidgetProviderImpl : WidgetProvider() {
    override fun provide(type: String): Widget<*, *> {
        return when (type) {
            TextStubs.widgetJson.type -> Text()
            ButtonStubs.widgetJson.type -> Button()
            else -> throw IllegalArgumentException("Unknown widget type: $type")
        }
    }
}