package com.clyo.android.ui.component.widget

import android.view.View
import com.clyo.data.properties.Properties

interface WidgetBinder<VIEW : View, PROP : Properties> {
    fun bind(view: VIEW, properties: PROP)
}