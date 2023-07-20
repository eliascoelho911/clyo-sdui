package com.clyo.android.ui.page

import android.content.Context
import com.clyo.android.ui.component.container.ContainerProvider
import com.clyo.android.ui.component.widget.WidgetProvider
import com.clyo.data.page.PageJson
import com.clyo.data.container.ContainerJson

internal class PageFactory(
    private val widgetProvider: WidgetProvider,
    private val containerProvider: ContainerProvider
) {
    fun create(context: Context, pageJson: PageJson): Page {
        val container = createContainer(context, pageJson.content)
        return Page(container)
    }

    private fun createContainer(
        context: Context,
        containerJson: ContainerJson
    ) = containerProvider.get(
        context = context,
        type = containerJson.type,
        content = createContent(context, containerJson)
    )

    private fun createContent(
        context: Context,
        containerJson: ContainerJson
    ) = containerJson.content.map { widgetJson ->
        widgetProvider.provide(context, widgetJson)
    }
}