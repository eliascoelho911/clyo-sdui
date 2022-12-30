package com.clyo.android.view

import android.view.View
import com.clyo.core.data.WidgetProperties
import com.clyo.core.widget.WidgetBinder

interface ViewBinder<T : View> : WidgetBinder<T> {
    override fun bind(widget: T, properties: WidgetProperties): T
}