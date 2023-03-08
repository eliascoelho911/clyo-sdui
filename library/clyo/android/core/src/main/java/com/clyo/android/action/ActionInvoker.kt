package com.clyo.android.action

import com.clyo.android.properties.AbstractPropertiesData

internal class ActionInvoker(
    private val action: Action,
    private val properties: AbstractPropertiesData
) {
    operator fun invoke() {
        action(properties)
    }
}