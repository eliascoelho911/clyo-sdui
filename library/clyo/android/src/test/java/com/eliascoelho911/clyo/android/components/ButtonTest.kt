package com.eliascoelho911.clyo.android.components

import com.eliascoelho911.clyo.core.data.ComponentData
import com.eliascoelho911.clyo.core.startClyo
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

        ComponentData(
            key = "android.button",
            properties = mapOf(
                "text" to JsonPrimitive("texto"),
                "style" to JsonPrimitive(1)
            )
        ).testComponentCreation(
            expected = Button(
                text = "texto",
                styleRes = 1
            )
        )
    }
}