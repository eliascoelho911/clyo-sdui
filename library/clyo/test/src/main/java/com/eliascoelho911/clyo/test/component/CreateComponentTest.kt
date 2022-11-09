package com.eliascoelho911.clyo.test.component

import com.eliascoelho911.clyo.core.component.Component
import com.eliascoelho911.clyo.core.data.ComponentData
import com.eliascoelho911.clyo.core.findComponentProvider
import kotlin.test.assertEquals

inline fun <reified T : Component> ComponentData.testComponentCreation(expected: T) {
    val componentCreated = findComponentProvider<T>()?.provide(this)
    assertEquals(expected, componentCreated)
}