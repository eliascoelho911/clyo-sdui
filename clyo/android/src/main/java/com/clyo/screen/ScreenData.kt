package com.clyo.screen

import com.clyo.component.container.ContainerData
import kotlinx.serialization.Serializable

@Serializable
data class ScreenData(
    val content: ContainerData
)