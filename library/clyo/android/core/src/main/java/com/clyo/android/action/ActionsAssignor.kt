package com.clyo.android.action

import android.view.View
import androidx.core.view.doOnAttach

internal interface ActionsAssignor {
    val actions: List<ActionInvoker>

    fun assign(destination: View)
}

internal class OnClickActionsAssignor(override val actions: List<ActionInvoker>) : ActionsAssignor {
    override fun assign(destination: View) {
        destination.setOnClickListener {
            actions.forEach { action ->
                action()
            }
        }
    }
}

internal class OnInitActionsAssignor(override val actions: List<ActionInvoker>) : ActionsAssignor {
    override fun assign(destination: View) {
        destination.doOnAttach {
            actions.forEach { action ->
                action()
            }
        }
    }
}