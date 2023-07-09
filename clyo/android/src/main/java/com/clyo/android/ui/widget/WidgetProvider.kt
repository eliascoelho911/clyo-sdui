package com.clyo.android.ui.widget

import android.content.Context

interface WidgetProvider {
    fun provide(context: Context, type: String): Widget<*, *>
}