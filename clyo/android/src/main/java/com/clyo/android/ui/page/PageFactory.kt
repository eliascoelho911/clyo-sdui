package com.clyo.android.ui.page

import android.content.Context
import com.clyo.android.ui.component.container.ViewGroupContainer
import com.clyo.data.container.ContainerJson

internal object PageFactory {
    private val widgetProvider get() = tools().widgetProvider
    private val containerProvider get() = tools().containerProvider

    fun create(context: Context, json: ContainerJson): ViewGroupContainer<*> {
        val content = createContent(json, context)
        return containerProvider.get(context, json.type, content)
    }

    private fun createContent(
        json: ContainerJson,
        context: Context
    ) = json.content.map { widgetJson ->
        widgetProvider.provide(context, widgetJson)
    }
}