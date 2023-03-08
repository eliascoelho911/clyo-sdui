package com.clyo.android.component

import android.content.Context
import android.view.View
import com.clyo.android.component.widget.WidgetFactory
import com.clyo.android.util.createViewInstance
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlin.reflect.KClass
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.Test

internal class WidgetFactoryTest {
    private val context: Context = mockk(relaxed = true)

    private val clyoDeclarations: ClyoDeclarations = mockk()

    private val componentFactory = WidgetFactory(context, clyoDeclarations)

    @Test
    fun `create component when Module contains all params`() {
        // Given
        val name = ComponentName("component")
        val componentBinder = mockk<ComponentBinder<View>>()
        val viewKClass = View::class
        val viewInstance = mockk<View>()
        val expected = Component(viewInstance, componentBinder)

        every { clyoDeclarations.viewKClass(name) } returns viewKClass
        every { clyoDeclarations.viewBinder<View>(name) } returns componentBinder
        viewKClass.mockCreateViewInstance(returns = viewInstance)

        // When
        val result = componentFactory.create(name)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `don't create component when Module not contains viewKClass`() {
        // Given
        val name = ComponentName("component")

        every { clyoDeclarations.viewKClass(name) } throws IllegalArgumentException()

        // Then
        assertFailsWith(IllegalArgumentException::class) {
            componentFactory.create(name)
        }
    }

    @Test
    fun `don't create component when Module not contains viewBinder`() {
        // Given
        val name = ComponentName("component")
        val viewKClass = View::class
        val viewInstance = mockk<View>()

        every { clyoDeclarations.viewKClass(name) } returns viewKClass
        every { clyoDeclarations.viewBinder<View>(name) } throws IllegalArgumentException()
        viewKClass.mockCreateViewInstance(returns = viewInstance)

        // Then
        assertFailsWith(IllegalArgumentException::class) {
            componentFactory.create(name)
        }
    }

    private fun <T : View> KClass<T>.mockCreateViewInstance(returns: T) {
        mockkStatic("com.clyo.android.util.ViewInstantiatorKt")
        every { createViewInstance(any()) } returns returns
    }
}