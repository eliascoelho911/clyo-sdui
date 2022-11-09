package com.eliascoelho911.clyo.test.component

import com.eliascoelho911.clyo.component.Component
import com.eliascoelho911.clyo.data.ComponentData
import com.eliascoelho911.clyo.findComponentProvider
import kotlin.test.assertEquals

inline fun <reified T : Component> ComponentData.testComponentCreation(expected: T) {
    val componentCreated = findComponentProvider<T>()?.provide(this)
    assertEquals(expected, componentCreated)
}