package com.eliascoelho911.clyo.test.component

import com.eliascoelho911.clyo.data.component.ComponentData
import com.eliascoelho911.clyo.findComponentProvider
import kotlin.test.assertEquals

inline fun <reified T : ComponentData> ComponentData.testComponentCreation(expected: T) {
    val componentCreated = findComponentProvider<T>()?.create(this)
    assertEquals(expected, componentCreated)
}