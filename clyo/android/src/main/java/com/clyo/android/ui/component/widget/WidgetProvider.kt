package com.clyo.android.ui.component.widget

import android.content.Context

interface WidgetProvider {
    fun provideInstanceByType(context: Context, type: String): Widget<*, *>
}