package com.clyo.android.action

import com.clyo.android.properties.BasePropertiesData

interface Action {
    operator fun invoke(properties: BasePropertiesData)
}