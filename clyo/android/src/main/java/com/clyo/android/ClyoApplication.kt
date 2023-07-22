package com.clyo.android

import android.content.Context
import com.clyo.android.component.ComponentType
import com.clyo.android.component.Container
import com.clyo.android.component.ContainerProvider
import com.clyo.android.component.Widget
import com.clyo.android.component.WidgetProvider
import java.util.Locale
import kotlinx.serialization.json.Json

object ClyoApplication {
    var widgetProvider: WidgetProvider = emptyWidgetProvider()

    var containerProvider: ContainerProvider = emptyContainerProvider()

    var json: Json = Json
}

private fun emptyWidgetProvider() = object : WidgetProvider {
    override fun provideByType(
        context: Context,
        type: ComponentType
    ): Widget<*, *> = isNotInitializedError("WidgetProvider")
}

private fun emptyContainerProvider() = object : ContainerProvider {
    override fun provideByType(
        context: Context,
        type: ComponentType,
    ): Container<*> = isNotInitializedError("ContainerProvider")
}

private fun isNotInitializedError(name: String): Nothing {
    throw IllegalStateException(
        "$name is not initialized. Use startClyo { ${
            name.replaceFirstChar {
                it.lowercase(
                    Locale.ROOT
                )
            }
        } = ... }"
    )
}

fun startClyo(block: ClyoApplication.() -> Unit) {
    ClyoApplication.apply(block)
}