package com.clyo.serializers.kotlinx.serialization

import com.eliascoelho911.clyo.data.ComponentDataContract
import com.eliascoelho911.clyo.data.ComponentName

interface ComponentDataKSContract : ComponentDataContract {
    override val properties: Map<ComponentName, PropertyValueKS>
}