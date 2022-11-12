package com.eliascoelho911.clyo.sample.data.model

import com.clyo.serializers.kotlinx.serialization.ComponentDataKSContract
import com.clyo.serializers.kotlinx.serialization.PropertyValueKS
import com.eliascoelho911.clyo.data.component.ComponentName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ClyoSampleScreenContentContract(
    @SerialName("name")
    override val name: ComponentName,
    @SerialName("properties")
    override val properties: Map<ComponentName, PropertyValueKS>
) : ComponentDataKSContract