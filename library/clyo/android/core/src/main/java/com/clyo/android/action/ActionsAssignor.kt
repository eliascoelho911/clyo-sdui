package com.clyo.android.action

import android.view.View

internal class ActionsAssignor(private val actions: List<ActionInvoker>) {
    fun assign(destination: View) {
        destination.setOnClickListener {
            actions.forEach { action ->
                action()
            }
        }
    }
}