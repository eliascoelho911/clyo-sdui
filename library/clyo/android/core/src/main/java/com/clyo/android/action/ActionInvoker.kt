package com.clyo.android.action

import com.clyo.android.properties.BasePropertiesData

internal class ActionInvoker(
    private val action: Action,
    private val properties: BasePropertiesData
) {
    operator fun invoke() {
        action(properties)
    }
}