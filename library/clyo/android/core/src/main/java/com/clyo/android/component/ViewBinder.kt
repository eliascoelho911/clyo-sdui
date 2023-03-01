package com.clyo.android.component

import android.view.View
import com.clyo.android.properties.AbstractPropertiesData
import com.clyo.android.properties.PropertiesAssignor

interface ViewBinder<T : View> : PropertiesAssignor<T>

@JvmInline
value class GenericViewBinder<T : View>(
    val binderBlock: T.(properties: AbstractPropertiesData) -> Unit
) : ViewBinder<T> {
    override fun assign(properties: AbstractPropertiesData, destination: T) {
        destination.binderBlock(properties)
    }
}