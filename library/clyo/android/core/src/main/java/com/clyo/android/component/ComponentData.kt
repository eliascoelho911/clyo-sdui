package com.clyo.android.component

import com.clyo.android.action.BaseActionsData
import com.clyo.android.properties.BasePropertiesData

@JvmInline
value class ComponentName(val name: String)

interface BaseComponentData {
    val name: ComponentName
    val properties: BasePropertiesData
    val actions: BaseActionsData
}