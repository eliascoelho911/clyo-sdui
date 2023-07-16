package com.clyo.android.ui.component.widget

import android.content.Context
import com.clyo.data.widget.WidgetJson

interface WidgetProvider {
    fun provide(context: Context, json: WidgetJson): Widget<*, *>
}