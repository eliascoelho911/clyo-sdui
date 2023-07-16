package com.clyo.sample.stub

import android.content.Context
import com.clyo.android.ui.page.PageFactory
import com.clyo.android.ui.component.container.ViewGroupContainer
import com.clyo.android.ui.component.widget.Widget
import com.clyo.sample.stub.container.Box
import com.clyo.sample.stub.container.Column

internal class ContainerFactoryImpl : PageFactory() {
    override fun provideInstance(
        context: Context,
        type: String,
        content: List<Widget<*, *>>
    ): ViewGroupContainer<*> {
        return when (type) {
            "box" -> Box(context, content)
            "column" -> Column(context, content)
            else -> throw IllegalArgumentException("Unknown container type: $type")
        }
    }
}