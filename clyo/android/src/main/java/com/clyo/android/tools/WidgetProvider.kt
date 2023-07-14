package com.clyo.android.tools

import android.content.Context
import com.clyo.android.ui.Widget
import com.clyo.data.widget.WidgetJson

interface WidgetProvider {
    fun provide(context: Context, json: WidgetJson): Widget<*, *>
}

internal val widgetProvider get() = tools().widgetProvider