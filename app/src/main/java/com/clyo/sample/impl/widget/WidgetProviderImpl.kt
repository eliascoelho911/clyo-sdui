package com.clyo.sample.impl.widget

import android.content.Context
import com.clyo.android.component.type.ComponentType
import com.clyo.android.component.widget.Widget
import com.clyo.android.component.widget.WidgetProvider
import com.clyo.sample.components.widget.Button
import com.clyo.sample.components.widget.Text

internal class WidgetProviderImpl : WidgetProvider {
    override fun provideByType(context: Context, type: ComponentType): Widget<*, *> {
        return when (type.type) {
            "text" -> Text(context)
            "button" -> Button(context)
            else -> throw IllegalArgumentException("Unknown widget to type ${type.type}")
        }
    }
}