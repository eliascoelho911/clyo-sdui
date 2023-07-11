package com.clyo.sample.stub.container

import android.content.Context
import android.widget.LinearLayout
import com.clyo.android.ui.Container
import com.clyo.data.container.ContainerJson
import com.clyo.sample.stub.widget.ButtonStubs
import com.clyo.sample.stub.widget.TextStubs

internal class Column : Container<LinearLayout>() {
    override fun newViewInstance(context: Context): LinearLayout {
        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
        }
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