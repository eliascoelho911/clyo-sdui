package com.clyo.viewbinder

import com.clyo.data.ViewName
import com.clyo.util.Registry

internal class ViewBinderRegistry : Registry<ViewName, ViewBinder<*>, ViewBinderModule>() {
    override val module = ViewBinderModule()
}