package com.clyo.component.widget.widgets

import com.clyo.component.properties.WidgetProperties
import com.clyo.component.type.ComponentType
import com.clyo.component.widget.WidgetData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("test")
internal data class TestWidgetProperties(
    val arg0: String,
    val arg1: String
) : WidgetProperties()

internal object TestWidgetStubs {
    val widgetData = WidgetData(
        type = ComponentType(type = "test"),
        properties = TestWidgetProperties(
            arg0 = "arg0_value",
            arg1 = "arg1_value"
        )
    )

    val jsonValue = """
        {
            "#widget": "test",
            "arg0": "arg0_value",
            "arg1": "arg1_value"
        }
    """.trimIndent()
}