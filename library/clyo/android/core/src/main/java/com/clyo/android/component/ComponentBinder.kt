package com.clyo.android.component

import android.view.View
import com.clyo.android.properties.AbstractPropertiesData
import com.clyo.android.properties.PropertiesAssignor

interface ComponentBinder<T: View> : PropertiesAssignor<T>

@JvmInline
value class ViewBinder<T : View>(
    val binderBlock: T.(properties: AbstractPropertiesData) -> Unit
) : ComponentBinder<T> {
    override fun assign(properties: AbstractPropertiesData, destination: T) {
        destination.binderBlock(properties)
    }
}