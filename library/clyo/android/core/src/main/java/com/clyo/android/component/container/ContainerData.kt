package com.clyo.android.component.container

import com.clyo.android.properties.AbstractPropertiesData
import com.clyo.android.properties.PropertiesData
import com.clyo.android.util.serializer.ContainerNameAsStringSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JvmInline
value class ContainerName(val name: String)

interface AbstractContainerData {
    val name: ContainerName
    val properties: AbstractPropertiesData
}

@Serializable
data class ContainerData(
    @SerialName("container_name")
    @Serializable(ContainerNameAsStringSerializer::class)
    override val name: ContainerName,
    @SerialName("properties")
    override val properties: PropertiesData
) : AbstractContainerData