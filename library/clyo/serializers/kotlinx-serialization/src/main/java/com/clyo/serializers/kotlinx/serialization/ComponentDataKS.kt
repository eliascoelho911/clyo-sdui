package com.clyo.serializers.kotlinx.serialization

import com.eliascoelho911.clyo.data.ComponentData
import com.eliascoelho911.clyo.data.ComponentName

interface ComponentDataKS : ComponentData {
    override val properties: Map<ComponentName, PropertyValueKS>
}