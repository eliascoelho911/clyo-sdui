package com.clyo.android

import com.clyo.android.component.container.AbstractContainerData
import com.clyo.android.component.container.ContainerData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface AbstractClyoData {
    val root: AbstractContainerData
}

@Serializable
data class ClyoData(
    @SerialName("root")
    override val root: ContainerData
) : AbstractClyoData