package com.clyo.android.ui.component

import android.view.View
import com.clyo.data.properties.Properties

interface ComponentRenderer<VIEW : View, PROP : Properties> {
    fun render(view: VIEW, properties: PROP)
}