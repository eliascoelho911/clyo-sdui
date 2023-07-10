package com.clyo.stubs

import com.clyo.data.container.ContainerJson

internal object ContainerStub {
    val jsonValue = """
        {
            "type": "layout",
            "content": [
                ${WidgetStub.Text.widgetJsonValue},
                ${WidgetStub.Button.widgetJsonValue}
            ]
        }
    """.trimIndent()

    val container = ContainerJson(
        type = "layout",
        content = listOf(
            WidgetStub.Text.widgetJson,
            WidgetStub.Button.widgetJson
        )
    )
}