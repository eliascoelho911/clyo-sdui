package com.clyo.android

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import androidx.fragment.app.Fragment
import com.clyo.android.module.Module

interface ClyoContext

fun ClyoContext.clyo(module: Module = Module()): Lazy<Clyo> = lazy {
    Clyo(
        context = getContextOrError(),
        module = module
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