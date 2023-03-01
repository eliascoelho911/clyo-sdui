package com.clyo.android.component

import com.clyo.android.properties.AbstractPropertiesData

@JvmInline
value class ComponentName(val name: String)

interface AbstractComponentData {
    val name: ComponentName
    val properties: AbstractPropertiesData
}