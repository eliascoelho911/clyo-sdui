package com.clyo.sample.stub.container

import android.content.Context
import android.widget.LinearLayout
import com.clyo.android.ui.component.container.ViewGroupContainer
import com.clyo.android.ui.component.widget.Widget
import com.clyo.data.container.ContainerJson
import com.clyo.sample.stub.widget.ButtonStubs
import com.clyo.sample.stub.widget.TextStubs

internal class Column(
    context: Context,
    override val content: List<Widget<*, *>>
) : ViewGroupContainer<LinearLayout>() {

    override val view: LinearLayout = LinearLayout(context).apply {
        orientation = LinearLayout.VERTICAL
    }
}

internal object ColumnStubs {
    val containerJsonValue = """
        {
            "type": "column",
            "content": [
                ${TextStubs.widgetJsonValue},
                ${ButtonStubs.widgetJsonValue}
            ]
        }
    """.trimIndent()
    val containerJson = ContainerJson(
        type = "column",
        content = listOf(
            TextStubs.widgetJson,
            ButtonStubs.widgetJson
        )
    )
}