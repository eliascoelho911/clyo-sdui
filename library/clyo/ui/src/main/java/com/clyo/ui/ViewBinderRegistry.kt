package com.clyo.ui

import com.clyo.data.ViewName
import com.clyo.ui.internal.module.ViewBinderModule

internal class ViewBinderRegistry : Registry<ViewName, ViewBinder<*>, ViewBinderModule>() {
    override val module = ViewBinderModule()
}