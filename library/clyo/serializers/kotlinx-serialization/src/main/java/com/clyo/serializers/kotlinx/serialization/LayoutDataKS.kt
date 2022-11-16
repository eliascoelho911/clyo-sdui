package com.clyo.serializers.kotlinx.serialization

import com.eliascoelho911.clyo.ComponentData
import com.eliascoelho911.clyo.ComponentName
import com.eliascoelho911.clyo.ComponentProperties
import com.eliascoelho911.clyo.LayoutData

data class LayoutDataKS(
    override val name: ComponentName,
    override val properties: ComponentProperties = ComponentProperties(),
    override val content: List<ComponentData> = emptyList()
) : LayoutData
