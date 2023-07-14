package com.clyo.sample.stub

import android.content.Context
import com.clyo.android.tools.ContainerFactory
import com.clyo.android.ui.Container
import com.clyo.android.ui.Widget
import com.clyo.sample.stub.container.Box
import com.clyo.sample.stub.container.Column

internal class ContainerFactoryImpl : ContainerFactory() {
    override fun provideInstance(
        context: Context,
        type: String,
        content: List<Widget<*, *>>
    ): Container<*> {
        return when (type) {
            "box" -> Box(context, content)
            "column" -> Column(context, content)
            else -> throw IllegalArgumentException("Unknown container type: $type")
        }
    }
}