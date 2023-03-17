package com.clyo.android.component

import com.clyo.android.action.BaseActionsData
import com.clyo.android.component.properties.PropertiesData

@JvmInline
value class ComponentName(val name: String)

interface BaseComponentData {
    val name: ComponentName
    //TODO Alterar depois para BasePropertiesData
    val properties: PropertiesData
    val actions: BaseActionsData
}