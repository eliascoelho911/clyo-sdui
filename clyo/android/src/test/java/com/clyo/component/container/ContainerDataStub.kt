package com.clyo.component.container

import com.clyo.component.type.ComponentType
import com.clyo.component.widget.widgets.TestWidgetStubs

internal object ContainerDataStub {
    val jsonValue = """
        {
            "#container": "test-container",
            "content": [
                ${TestWidgetStubs.jsonValue}
            ]
        }
    """.trimIndent()

    val container = ContainerData(
        type = ComponentType("test-container"),
        content = listOf(
            TestWidgetStubs.widgetData
        )
    )
}