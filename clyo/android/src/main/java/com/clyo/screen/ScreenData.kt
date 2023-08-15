package com.clyo.screen

import com.clyo.component.container.ContainerData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScreenData(
    @SerialName("content")
    val content: ContainerData
)