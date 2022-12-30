package com.clyo.android.view

import com.clyo.core.data.WidgetName
import com.clyo.core.util.Registry

internal class ViewBinderRegistry : Registry<WidgetName, ViewBinder<*>, ViewBinderModule>() {
    override val module = ViewBinderModule()
}