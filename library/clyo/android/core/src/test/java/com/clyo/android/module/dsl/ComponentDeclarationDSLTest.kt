package com.clyo.android.module.dsl

import android.view.View
import com.clyo.android.component.ComponentName
import com.clyo.android.component.ViewBinder
import com.clyo.android.component.properties.BasePropertiesData
import com.clyo.android.dsl.ComponentDeclarationDSL
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.slot
import kotlin.test.assertEquals
import org.junit.Test

internal class ComponentDeclarationDSLTest {

    @OptIn(ClyoInternalAPI::class)
    @Test
    fun `binder declare GenericViewBinder`() {
        // Given
        val componentModule = mockk<ComponentModule>(relaxed = true)
        val componentName = ComponentName("myComponent")
        val componentDeclarationDSL = ComponentDeclarationDSL<View>(componentName, componentModule)
        val block: View.(properties: BasePropertiesData) -> Unit = {
            // do nothing
        }
        val slot = slot<() -> ViewBinder<View>>()
        val expected = ViewBinder(block)

        every { componentModule.declare(componentName, viewBinder = capture(slot)) } just Runs

        // When
        componentDeclarationDSL.binder(block)

        // Then
        val result = slot.captured.invoke()
        assertEquals(expected, result)
    }
}