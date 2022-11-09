package com.eliascoelho911.clyo.android.components

import com.eliascoelho911.clyo.data.ComponentData
import com.eliascoelho911.clyo.startClyo
import com.eliascoelho911.clyo.test.component.testComponentCreation
import kotlinx.serialization.json.JsonPrimitive
import org.junit.Test

class ButtonTest {
    @Test
    fun `SHOULD convert by data WHEN all required properties are declared`() {
        startClyo {
            addComponentProvider(
                Button::class to ButtonProvider
            )
        }
        val componentData = ComponentData(
            key = "android.button",
            properties = mapOf(
                "text" to JsonPrimitive("texto"),
                "style" to JsonPrimitive(1)
            )
        )
        val expected = Button(
            text = "texto",
            styleRes = 1
        )

        componentData.testComponentCreation(expected)
    }
}