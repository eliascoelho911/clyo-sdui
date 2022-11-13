package com.eliascoelho911.clyo.sample.data.model

import com.clyo.serializers.kotlinx.serialization.ComponentDataKS
import com.clyo.serializers.kotlinx.serialization.PropertyValueKS
import com.eliascoelho911.clyo.data.ComponentName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ClyoComponentData(
    @SerialName("name")
    override val name: ComponentName,
    @SerialName("properties")
    override val properties: Map<ComponentName, PropertyValueKS>
) : ComponentDataKS