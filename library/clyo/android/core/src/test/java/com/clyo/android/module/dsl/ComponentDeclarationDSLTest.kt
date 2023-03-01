package com.clyo.android.module.dsl

import android.view.View
import com.clyo.android.annotation.ClyoInternalAPI
import com.clyo.android.component.ComponentName
import com.clyo.android.component.GenericViewBinder
import com.clyo.android.module.Module
import com.clyo.android.properties.AbstractPropertiesData
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
        val module = mockk<Module>(relaxed = true)
        val componentName = ComponentName("myComponent")
        val componentDeclarationDSL = ComponentDeclarationDSL<View>(componentName, module)
        val block: View.(properties: AbstractPropertiesData) -> Unit = {
            // do nothing
        }
        val slot = slot<() -> GenericViewBinder<View>>()
        val expected = GenericViewBinder(block)

        every { module.declare(componentName, viewBinder = capture(slot)) } just Runs

        // When
        componentDeclarationDSL.binder(block)

        // Then
        val result = slot.captured.invoke()
        assertEquals(expected, result)
    }
}