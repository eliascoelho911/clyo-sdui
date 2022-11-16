package com.clyo.serializers.kotlinx.serialization

import com.eliascoelho911.clyo.ComponentData
import com.eliascoelho911.clyo.ComponentName
import com.eliascoelho911.clyo.ComponentProperties

data class ComponentDataKS(
    override val name: ComponentName,
    override val properties: ComponentProperties
) : ComponentData
