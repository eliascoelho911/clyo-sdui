package com.clyo.android.module.dsl

import android.view.View
import com.clyo.android.component.ComponentName
import com.clyo.android.component.ViewBinder
import com.clyo.android.component.container.dsl.ContainerDeclarationDSL
import com.clyo.android.properties.AbstractPropertiesData
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.slot
import kotlin.test.assertEquals
import org.junit.Test

internal class ContainerDeclarationDSLTest {

    @OptIn(ClyoInternalAPI::class)
    @Test
    fun `binder declare GenericViewBinder`() {
        // Given
        val componentModule = mockk<ComponentModule>(relaxed = true)
        val componentName = ComponentName("myComponent")
        val containerDeclarationDSL = ContainerDeclarationDSL<View>(componentName, componentModule)
        val block: View.(properties: AbstractPropertiesData) -> Unit = {
            // do nothing
        }
        val slot = slot<() -> ViewBinder<View>>()
        val expected = ViewBinder(block)

        every { componentModule.declare(componentName, viewBinder = capture(slot)) } just Runs

        // When
        containerDeclarationDSL.binder(block)

        // Then
        val result = slot.captured.invoke()
        assertEquals(expected, result)
    }
}