package com.clyo.android.view.renderer

import android.view.View
import com.clyo.core.data.PropertiesData
import com.clyo.core.widget.WidgetBinder

interface ViewBinder<T : View> : WidgetBinder<T> {
    override fun bind(widget: T, properties: PropertiesData): T
}