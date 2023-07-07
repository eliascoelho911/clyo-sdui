package com.clyo.android

import com.clyo.android.component.container.BaseContainerData
import com.clyo.android.component.container.ContainerData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface BaseClyoData {
    val root: BaseContainerData
}

@Serializable
data class ClyoData(
    @SerialName("root")
    override val root: ContainerData
) : BaseClyoData