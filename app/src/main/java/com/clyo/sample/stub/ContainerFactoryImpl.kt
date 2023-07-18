package com.clyo.sample.stub

import android.content.Context
import com.clyo.android.ui.component.container.Container
import com.clyo.android.ui.component.container.ContainerProvider
import com.clyo.android.ui.component.widget.Widget
import com.clyo.sample.components.container.column

internal class ContainerFactoryImpl : ContainerProvider {
    override fun get(
        context: Context,
        type: String,
        content: List<Widget<*, *>>
    ): Container<*> {
        return when (type) {
            "column" -> column(context, content)
            else -> throw IllegalArgumentException("Unknown container type: $type")
        }
    }
}