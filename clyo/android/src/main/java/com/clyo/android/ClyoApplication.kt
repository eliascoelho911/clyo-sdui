package com.clyo.android

import android.content.Context
import com.clyo.android.ui.component.container.ContainerProvider
import com.clyo.android.ui.component.container.Container
import com.clyo.android.ui.component.widget.Widget
import com.clyo.android.ui.component.widget.WidgetProvider
import com.clyo.data.widget.WidgetJson
import java.util.Locale
import kotlinx.serialization.json.Json

object ClyoApplication {
    var widgetProvider: WidgetProvider = emptyWidgetProvider()

    var containerProvider: ContainerProvider = emptyContainerProvider()

    var json: Json = Json
}

private fun emptyWidgetProvider() = object : WidgetProvider {
    override fun provide(
        context: Context,
        json: WidgetJson
    ): Widget<*, *> = isNotInitializedError("WidgetProvider")
}

private fun emptyContainerProvider() = object : ContainerProvider {
    override fun get(
        context: Context,
        type: String,
        content: List<Widget<*, *>>
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