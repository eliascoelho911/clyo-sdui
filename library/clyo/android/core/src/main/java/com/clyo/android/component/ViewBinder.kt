package com.clyo.android.component

import android.view.View
import com.clyo.android.properties.PropertiesAssignor
import com.clyo.data.PropertiesData

interface ViewBinder<T : View> : PropertiesAssignor<T>

@JvmInline
value class GenericViewBinder<T : View>(
    val binderBlock: T.(properties: PropertiesData) -> Unit
) : ViewBinder<T> {
    override fun assign(properties: PropertiesData, destination: T) {
        destination.binderBlock(properties)
    }
}