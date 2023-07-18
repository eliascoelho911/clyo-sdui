package com.clyo.android.ui.component.container

import android.content.Context
import com.clyo.android.ui.component.widget.Widget

interface ContainerProvider {
    fun get(context: Context, type: String, content: List<Widget<*, *>>): Container<*>
}