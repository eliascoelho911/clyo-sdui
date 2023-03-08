package com.clyo.android.component

import android.view.View
import com.clyo.android.properties.AbstractPropertiesData

//Todo refatorar para a mesma estrutura das actions
abstract class ComponentBinder<T : View> {
    protected abstract val binderBlock: T.(properties: AbstractPropertiesData) -> Unit

    fun bind(properties: AbstractPropertiesData, destination: T) {
        destination.binderBlock(properties)
    }
}

class ComponentBinderImpl<T : View>(
    override val binderBlock: T.(properties: AbstractPropertiesData) -> Unit = {}
) : ComponentBinder<T>()