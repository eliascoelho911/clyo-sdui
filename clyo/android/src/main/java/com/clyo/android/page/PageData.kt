package com.clyo.android.page

import com.clyo.android.component.container.ContainerData
import kotlinx.serialization.Serializable

@Serializable
data class PageData(
    val content: ContainerData
)