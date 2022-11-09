package com.eliascoelho911.clyo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClyoData(
    @SerialName("root")
    val root: LayoutData,
    @SerialName("onInitAction")
    val onInitAction: ActionData
)