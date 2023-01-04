package com.clyo.serializer.kotlinxserialization

import com.clyo.core.data.ClyoData
import com.clyo.core.data.ContainerData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClyoData(
    @SerialName("root")
    override val root: ContainerData
) : ClyoData