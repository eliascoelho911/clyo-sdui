package com.clyo.android.component

import android.view.View
import com.clyo.android.properties.BasePropertiesData

abstract class ComponentBinder<T : View> {
    protected abstract val binderBlock: T.(properties: BasePropertiesData) -> Unit

    fun bind(properties: BasePropertiesData, destination: T) {
        destination.binderBlock(properties)
    }
}

class ComponentBinderImpl<T : View>(
    override val binderBlock: T.(properties: BasePropertiesData) -> Unit = {}
) : ComponentBinder<T>()