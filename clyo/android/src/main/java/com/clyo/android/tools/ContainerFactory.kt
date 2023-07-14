package com.clyo.android.tools

import android.content.Context
import com.clyo.android.ui.Container
import com.clyo.android.ui.Widget
import com.clyo.data.container.ContainerJson

abstract class ContainerFactory {
    protected abstract fun provideInstance(
        context: Context,
        type: String,
        content: List<Widget<*, *>>
    ): Container<*>

    fun create(context: Context, json: ContainerJson): Container<*> {
        val content = createContent(json, context)
        return provideInstance(context, json.type, content)
    }

    private fun createContent(
        json: ContainerJson,
        context: Context
    ) = json.content.map { widgetJson ->
        widgetProvider.provide(context, widgetJson)
    }
}

internal val containerFactory get() = tools().containerFactory