package com.clyo.android.properties

interface PropertiesAssignor<T> {
    fun assign(properties: AbstractPropertiesData, destination: T)
}