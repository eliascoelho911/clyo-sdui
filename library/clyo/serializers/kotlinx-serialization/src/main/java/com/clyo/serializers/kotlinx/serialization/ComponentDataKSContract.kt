package com.clyo.serializers.kotlinx.serialization

import com.eliascoelho911.clyo.data.component.ComponentDataContract
import com.eliascoelho911.clyo.data.component.ComponentName


interface ComponentDataKSContract : ComponentDataContract {
    override val properties: Map<ComponentName, PropertyValueKS>
}