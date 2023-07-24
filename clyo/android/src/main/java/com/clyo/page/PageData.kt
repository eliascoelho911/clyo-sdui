package com.clyo.page

import com.clyo.component.container.ContainerData
import kotlinx.serialization.Serializable

@Serializable
data class PageData(
    val content: ContainerData
)