package com.clyo.serializer.kotlinxserialization

import com.clyo.core.data.ClyoData
import com.clyo.core.data.WidgetData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClyoData(
    @SerialName("content")
    override val content: WidgetData
) : ClyoData