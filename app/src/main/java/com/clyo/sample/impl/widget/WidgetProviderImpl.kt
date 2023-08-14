package com.clyo.sample.impl.widget

import android.content.Context
import com.clyo.android.component.Widget
import com.clyo.android.widget.WidgetProvider
import com.clyo.component.type.ComponentType
import com.clyo.sample.presentation.components.widgets.Text

internal class WidgetProviderImpl : WidgetProvider {
    override fun provideByType(context: Context, type: ComponentType): Widget<*, *> {
        return when (type.type) {
            "text" -> Text(context)
            else -> throw IllegalArgumentException("Unknown type: $type")
        }
    }
}