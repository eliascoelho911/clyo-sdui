package com.clyo.sample.stub.container

import android.content.Context
import android.widget.FrameLayout
import com.clyo.android.ui.component.container.ViewGroupContainer
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.container.ContainerJson
import com.clyo.sample.stub.widget.ButtonStubs
import com.clyo.sample.stub.widget.TextStubs

internal class Box(
    context: Context,
    override val content: List<Widget<*, *>>
) : ViewGroupContainer<FrameLayout>() {
    override val view: FrameLayout = FrameLayout(context)
}

internal object BoxStubs {
    val containerJsonValue = """
        {
            "type": "box",
            "content": [
                ${TextStubs.widgetJsonValue},
                ${ButtonStubs.widgetJsonValue}
            ]
        }
    """.trimIndent()
    val containerJson = ContainerJson(
        type = "box",
        content = listOf(
            TextStubs.widgetJson,
            ButtonStubs.widgetJson
        )
    )
}