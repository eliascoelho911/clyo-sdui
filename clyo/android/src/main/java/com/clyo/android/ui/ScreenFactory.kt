package com.clyo.android.ui

import android.content.Context
import com.clyo.android.ui.layout.Layout
import com.clyo.android.ui.layout.LayoutProvider
import com.clyo.android.ui.widget.WidgetProvider
import com.clyo.data.layout.LayoutJson

internal class ScreenFactory(
    private val layoutProvider: LayoutProvider,
    private val widgetProvider: WidgetProvider,
) {
    fun create(context: Context, layoutJson: LayoutJson): Layout<*> {
        val layout = layoutProvider.provide(context, layoutJson.type)

        layoutJson.content.forEach { widgetJson ->
            layout.add(widgetProvider.provide(context, widgetJson.type))
        }

        return layout
    }
}