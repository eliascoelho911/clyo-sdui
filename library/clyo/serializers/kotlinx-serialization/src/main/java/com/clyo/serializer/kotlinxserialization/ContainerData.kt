package com.clyo.serializer.kotlinxserialization

import com.clyo.data.ContainerName
import com.clyo.serializer.kotlinxserialization.serializer.ContainerNameAsStringSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.clyo.data.ContainerData as IContainerData

@Serializable
data class ContainerData(
    @SerialName("container_name")
    @Serializable(ContainerNameAsStringSerializer::class)
    override val name: ContainerName,
    @SerialName("properties")
    override val properties: PropertiesData
) : IContainerData