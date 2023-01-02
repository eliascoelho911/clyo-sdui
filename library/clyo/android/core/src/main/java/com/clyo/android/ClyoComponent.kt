package com.clyo.android

import android.content.Context
import android.content.ContextWrapper
import android.view.View
import androidx.fragment.app.Fragment
import com.clyo.android.view.renderer.ViewBinderModule
import com.clyo.android.view.renderer.ViewClassModule
import com.clyo.core.Clyo
import com.clyo.core.ClyoComponent

fun ClyoComponent.clyoAndroid(): Lazy<Clyo> = lazy {
    ClyoAndroid(
        context = getContextOrError(),
        viewBinderModule = ViewBinderModule(),
        viewClassModule = ViewClassModule()
    )
}

private fun ClyoComponent.getContextOrError(): Context {
    return when (this) {
        is View -> context
        is Fragment -> requireContext()
        is ContextWrapper -> baseContext
        else -> error("Context not found")
    }
}
