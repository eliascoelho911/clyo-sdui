package com.clyo.android

import com.clyo.android.component.AbstractComponentData
import com.clyo.android.component.ComponentData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface AbstractClyoData {
    val root: AbstractComponentData
}

@Serializable
data class ClyoData(
    @SerialName("root")
    override val root: ComponentData
) : AbstractClyoData