package com.clyo.sample.stub

import android.content.Context
import com.clyo.android.ui.component.widget.WidgetProvider
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.widget.WidgetJson
import com.clyo.sample.stub.widget.Button
import com.clyo.sample.stub.widget.ButtonStubs
import com.clyo.sample.stub.widget.Text
import com.clyo.sample.stub.widget.TextStubs

internal class WidgetProviderImpl : WidgetProvider {
    override fun provide(context: Context, json: WidgetJson): Widget<*, *> {
        return when (json.type) {
            TextStubs.widgetJson.type -> Text(context, json.id)
            ButtonStubs.widgetJson.type -> Button(context, json.id)
            else -> throw IllegalArgumentException("Unknown widget type: ${json.type}")
        }
    }
}