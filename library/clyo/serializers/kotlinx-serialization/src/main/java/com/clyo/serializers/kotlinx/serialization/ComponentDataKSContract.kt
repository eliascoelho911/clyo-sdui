package com.clyo.serializers.kotlinx.serialization

import com.eliascoelho911.clyo.data.ComponentDataContract

interface ComponentDataKSContract : ComponentDataContract {
    override val properties: Map<String, PropertyValueKS>
}