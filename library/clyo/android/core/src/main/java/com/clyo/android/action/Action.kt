package com.clyo.android.action

import com.clyo.android.properties.AbstractPropertiesData

interface Action {
    operator fun invoke(properties: AbstractPropertiesData)
}