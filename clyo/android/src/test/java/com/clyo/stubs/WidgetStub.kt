package com.clyo.stubs

import com.clyo.data.widget.WidgetJson
import com.clyo.widget.ButtonProperties
import com.clyo.widget.TextProperties

internal object WidgetStub {

    object Text {
        val id = "txt"

        val type = "text"

        val widgetJsonValue = """
        {
            "type": $type,
            "id": $id
        }
    """.trimIndent()

        val widgetJson = WidgetJson(type = type, id = id)

        val propertiesJsonValue = """
        {
            "text": "test text"
        }
    """.trimIndent()

        val properties = TextProperties(text = "test text")
    }

    object Button {
        val widgetJsonValue = """
        {
            "type": "button",
            "id": "btn"
        }
    """.trimIndent()

        val widgetJson = WidgetJson(type = "button", id = "btn")

        val propertiesJsonValue = """
        {
            "text": "test button",
            "isDisabled": false
        }
    """.trimIndent()

        val properties = ButtonProperties(text = "test button", isDisabled = false)
    }
}

