package com.eliascoelho911.clyo.android.components

import com.eliascoelho911.clyo.startClyo
import com.eliascoelho911.clyo.test.component.MockComponentData
import com.eliascoelho911.clyo.test.component.MockPropertyValue
import com.eliascoelho911.clyo.test.component.testComponentCreation
import org.junit.Test

class ButtonTest {
    @Test
    fun `SHOULD convert by data WHEN all required properties are declared`() {
        startClyo {
            addComponentProvider(
                Button::class to ButtonProvider
            )
        }
        val componentData = MockComponentData(
            name = "android.button",
            properties = mapOf(
                "text" to MockPropertyValue("texto"),
                "style" to MockPropertyValue(1)
            )
        )
        val expected = Button(
            text = "texto",
            styleRes = 1
        )

        componentData.testComponentCreation(expected)
    }
}