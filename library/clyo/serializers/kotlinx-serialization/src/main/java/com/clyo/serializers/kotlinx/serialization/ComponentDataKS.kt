package com.clyo.serializers.kotlinx.serialization

import com.eliascoelho911.clyo.ComponentData
import com.eliascoelho911.clyo.ComponentName

interface ComponentDataKS : ComponentData {
    override val properties: Map<ComponentName, PropertyValueKS>
}