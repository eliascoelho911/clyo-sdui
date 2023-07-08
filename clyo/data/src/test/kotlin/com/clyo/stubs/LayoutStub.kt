package com.clyo.stubs

import com.clyo.data.layout.LayoutJson

internal object LayoutStub {
    val jsonValue = """
        {
            "type": "layout",
            "content": [
                ${WidgetStub.Text.widgetJsonValue},
                ${WidgetStub.Button.widgetJsonValue}
            ]
        }
    """.trimIndent()

    val layout = LayoutJson(
        type = "layout",
        content = listOf(
            WidgetStub.Text.widgetJson,
            WidgetStub.Button.widgetJson
        )
    )
}