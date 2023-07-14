package com.clyo.android.tools

import com.clyo.android.ui.Widget
import com.clyo.data.widget.WidgetJson

interface WidgetProvider {
    fun provide(json: WidgetJson): Widget<*, *>
}