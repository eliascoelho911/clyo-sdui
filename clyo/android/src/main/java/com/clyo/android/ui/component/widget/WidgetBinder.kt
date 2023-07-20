package com.clyo.android.ui.component.widget

import android.view.View
import com.clyo.data.widget.WidgetProperties

interface WidgetBinder<VIEW : View, PROP : WidgetProperties> {
    fun bind(view: VIEW, properties: PROP)
}