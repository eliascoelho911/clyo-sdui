package com.eliascoelho911.notate.clyo.core.data

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("layoutType")
sealed class LayoutData

@SerialName("COLUMN")
internal data class ColumnData(
    @SerialName("content") val content: List<ComponentData>
) : LayoutData()