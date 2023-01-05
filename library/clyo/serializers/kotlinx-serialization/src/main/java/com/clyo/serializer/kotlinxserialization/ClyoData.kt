package com.clyo.serializer.kotlinxserialization

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.clyo.data.ClyoData as IClyoData

@Serializable
data class ClyoData(
    @SerialName("container")
    override val container: ComponentData
) : IClyoData