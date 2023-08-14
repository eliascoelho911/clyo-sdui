package com.clyo.android.widget

import android.content.Context
import com.clyo.android.component.Widget
import com.clyo.component.type.ComponentType

interface WidgetProvider {
    fun provideByType(context: Context, type: ComponentType): Widget<*, *>
}