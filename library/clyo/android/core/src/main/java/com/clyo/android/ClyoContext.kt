package com.clyo.android

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import androidx.fragment.app.Fragment
import com.clyo.android.component.ComponentModule

interface ClyoContext

fun ClyoContext.clyo(componentModule: ComponentModule): Lazy<ClyoEngine> = lazy {
    ClyoEngine(
        context = getContextOrError(),
        componentModule = componentModule
    )
}

private fun ClyoContext.getContextOrError(): Context {
    return when (this) {
        is View -> context
        is Fragment -> requireContext()
        is Activity -> this
        is ContextWrapper -> baseContext
        else -> error("Context not found")
    }
}