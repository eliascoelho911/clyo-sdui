package com.clyo.android.action

import android.view.View
import com.clyo.android.component.properties.BasePropertiesData

interface Action {
    operator fun invoke(properties: BasePropertiesData)
}

internal class ActionInvoker(
    private val action: Action,
    private val properties: BasePropertiesData
) {
    operator fun invoke() {
        action(properties)
    }
}

internal interface ActionsAssignor {
    val actions: List<ActionInvoker>

    fun assign(destination: View)
}