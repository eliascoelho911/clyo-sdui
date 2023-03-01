package com.clyo.android.component.widget

import android.view.View
import com.clyo.android.component.ComponentBinder
import com.clyo.android.properties.AbstractPropertiesData

@JvmInline
value class WidgetBinder<T : View>(
    val binderBlock: T.(properties: AbstractPropertiesData) -> Unit
) : ComponentBinder<T> {
    override fun assign(properties: AbstractPropertiesData, destination: T) {
        destination.binderBlock(properties)
    }
}