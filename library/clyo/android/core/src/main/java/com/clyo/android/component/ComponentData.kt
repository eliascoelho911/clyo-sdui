package com.clyo.android.component

import com.clyo.android.action.AbstractActionData
import com.clyo.android.properties.AbstractPropertiesData

//TODO Remover
@JvmInline
value class ComponentName(val name: String)

interface AbstractComponentData {
    val name: ComponentName
    val properties: AbstractPropertiesData
    val onClickActions: List<AbstractActionData>
}