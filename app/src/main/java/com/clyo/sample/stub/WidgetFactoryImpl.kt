package com.clyo.sample.stub

import com.clyo.android.ui.component.WidgetFactory
import com.clyo.android.ui.component.widget.Widget
import com.clyo.sample.stub.widget.Button
import com.clyo.sample.stub.widget.ButtonStubs
import com.clyo.sample.stub.widget.Text
import com.clyo.sample.stub.widget.TextStubs

internal class WidgetFactoryImpl : WidgetFactory() {
    override fun provide(type: String): Widget<*, *> {
        return when (type) {
            TextStubs.widgetJson.type -> Text()
            ButtonStubs.widgetJson.type -> Button()
            else -> throw IllegalArgumentException("Unknown widget type: $type")
        }
    }
}