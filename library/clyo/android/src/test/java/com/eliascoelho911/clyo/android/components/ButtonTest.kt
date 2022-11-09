package com.eliascoelho911.clyo.android.components

import com.eliascoelho911.clyo.core.Clyo
import com.eliascoelho911.clyo.core.data.component.ComponentData
import com.eliascoelho911.clyo.test.component.assertCreationSuccess
import kotlinx.serialization.json.JsonPrimitive
import org.junit.Test

class ButtonTest {
    @Test
    fun `SHOULD convert by data WHEN all required properties are declared`() {
        Clyo.componentFactoryModule.add("android.button") { ButtonFactory() }

        ComponentData(
            key = "android.button",
            properties = mapOf(
                "text" to JsonPrimitive("texto"),
                "style" to JsonPrimitive(1)
            )
        ).assertCreationSuccess(expected = Button(
            text = "texto",
            styleRes = 1
        ))
    }
}