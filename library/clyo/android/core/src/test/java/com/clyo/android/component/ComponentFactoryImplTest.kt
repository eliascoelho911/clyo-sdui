package com.clyo.android.component

import android.content.Context
import android.view.View
import com.clyo.android.module.Module
import com.clyo.android.util.createViewInstance
import com.clyo.data.ComponentName
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlin.reflect.KClass
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.Test

internal class ComponentFactoryImplTest {
    private val context: Context = mockk(relaxed = true)

    private val module: Module = mockk()

    private val componentFactory = ComponentFactoryImpl(context, module)

    @Test
    fun `create component when Module contains all params`() {
        // Given
        val name = ComponentName("component")
        val viewBinder = mockk<ViewBinder<View>>()
        val viewKClass = View::class
        val viewInstance = mockk<View>()
        val expected = Component(viewInstance, viewBinder)

        every { module.viewKClass(name) } returns viewKClass
        every { module.viewBinder<View>(name) } returns viewBinder
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

        every { module.viewKClass(name) } throws IllegalArgumentException()

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

        every { module.viewKClass(name) } returns viewKClass
        every { module.viewBinder<View>(name) } throws IllegalArgumentException()
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