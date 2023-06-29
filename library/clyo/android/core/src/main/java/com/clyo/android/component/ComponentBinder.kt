package com.clyo.android.component

import android.view.View
import com.clyo.android.component.properties.BasePropertiesData

//Todo Deve ser internal
@JvmInline
value class ComponentBinder<T : View>(
    private val binderBlock: T.(properties: BasePropertiesData) -> Unit = {}
) {
    fun bind(properties: BasePropertiesData, destination: T) {
        destination.binderBlock(properties)
    }
}

internal fun ComponentBinder<*>?.orEmpty(): ComponentBinder<out View> {
    return this ?: emptyBinder()
}

internal fun emptyBinder(): ComponentBinder<*> = ComponentBinder<View>()