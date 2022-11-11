package com.eliascoelho911.clyo.android.components

import com.eliascoelho911.clyo.startClyo
import com.eliascoelho911.clyo.test.component.MockComponentData
import com.eliascoelho911.clyo.test.component.MockPropertyValue
import com.eliascoelho911.clyo.test.component.testComponentCreation
import org.junit.Test

class ButtonDataTest {
    @Test
    fun `SHOULD convert by data WHEN all required properties are declared`() {
        startClyo {
            addComponentProvider(
                ButtonData::class to ButtonDataCreator
            )
        }
        val componentData = MockComponentData(
            name = "android.button",
            properties = mapOf(
                "text" to MockPropertyValue("texto"),
                "style" to MockPropertyValue(1)
            )
        )
        val expected = ButtonData(
            text = "texto",
            styleRes = 1
        )

        componentData.testComponentCreation(expected)
    }
}