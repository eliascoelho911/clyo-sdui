package com.clyo.android.properties

import com.clyo.data.PropertiesData

interface PropertiesAssignor<T> {
    fun assign(properties: PropertiesData, destination: T)
}