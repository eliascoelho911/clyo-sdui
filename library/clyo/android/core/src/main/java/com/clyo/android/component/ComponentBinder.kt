package com.clyo.android.component

import android.view.View
import com.clyo.android.properties.AbstractPropertiesData
import com.clyo.android.properties.PropertiesAssignor

abstract class ComponentBinder<T : View>: PropertiesAssignor<T> {
    protected abstract val binderBlock: T.(properties: AbstractPropertiesData) -> Unit

    override fun assign(properties: AbstractPropertiesData, destination: T) {
        destination.binderBlock(properties)
    }
}