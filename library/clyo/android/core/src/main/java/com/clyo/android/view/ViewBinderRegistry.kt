package com.clyo.android.view

import com.clyo.core.data.ViewName
import com.clyo.core.util.Registry

internal class ViewBinderRegistry : Registry<ViewName, ViewBinder<*>, ViewBinderModule>() {
    override val module = ViewBinderModule()
}