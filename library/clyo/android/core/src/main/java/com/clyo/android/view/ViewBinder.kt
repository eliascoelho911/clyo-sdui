package com.clyo.android.view

import android.view.View
import com.clyo.core.data.WidgetProperties

interface ViewBinder<T : View> {
    fun bind(view: T, properties: WidgetProperties)
}