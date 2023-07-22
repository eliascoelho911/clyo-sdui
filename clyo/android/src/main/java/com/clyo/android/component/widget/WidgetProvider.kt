package com.clyo.android.component.widget

import android.content.Context
import com.clyo.android.component.type.ComponentType

interface WidgetProvider {
    fun provideByType(context: Context, type: ComponentType): Widget<*, *>
}