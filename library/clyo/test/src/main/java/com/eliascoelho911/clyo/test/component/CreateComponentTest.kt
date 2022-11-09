package com.eliascoelho911.clyo.test.component

import com.eliascoelho911.clyo.core.component.Component
import com.eliascoelho911.clyo.core.data.ComponentData
import kotlin.test.assertEquals

inline fun <reified T : Component> ComponentData.assertCreationSuccess(expected: T) {
    val componentCreated = createComponent(expected::class)
    assertEquals(expected, componentCreated)
}