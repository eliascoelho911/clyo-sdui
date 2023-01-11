package com.clyo.data

@JvmInline
value class ContainerName(val name: String)

interface ContainerData {
    val name: ContainerName
    val properties: PropertiesData
}