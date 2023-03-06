package com.clyo.android.component.container

import android.view.View
import android.view.ViewGroup
import com.clyo.android.properties.AbstractPropertiesData

interface ClyoContainer {
    val container: ViewGroup

    fun addWidget(view: View, layoutProperties: AbstractPropertiesData)
}