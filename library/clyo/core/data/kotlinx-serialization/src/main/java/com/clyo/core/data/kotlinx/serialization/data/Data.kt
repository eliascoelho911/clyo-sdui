package com.clyo.core.data.kotlinx.serialization.data

import com.clyo.core.data.ComponentData
import com.clyo.core.data.ComponentName
import com.clyo.core.data.ComponentProperties
import com.clyo.core.data.LayoutData

data class ComponentData(
    override val name: ComponentName,
    override val properties: ComponentProperties
) : ComponentData

data class LayoutData(
    override val name: ComponentName,
    override val properties: ComponentProperties = ComponentProperties(),
    override val content: List<ComponentData> = emptyList()
) : LayoutData
