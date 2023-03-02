package com.clyo.android.component.container

import android.view.View
import com.clyo.android.properties.PropertiesData

interface ClyoContainerView {
    fun addWidget(view: View, layoutProperties: PropertiesData)
}