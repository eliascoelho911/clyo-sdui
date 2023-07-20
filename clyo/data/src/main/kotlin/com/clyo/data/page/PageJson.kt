package com.clyo.data.page

import com.clyo.data.container.ContainerJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageJson(
    @SerialName("content")
    override val content: ContainerJson
) : PageData