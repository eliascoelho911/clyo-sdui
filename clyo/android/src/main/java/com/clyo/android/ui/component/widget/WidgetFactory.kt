package com.clyo.android.ui.component.widget

import android.content.Context

interface WidgetFactory {
    fun provideInstanceByType(context: Context, type: String): Widget<*, *>
}