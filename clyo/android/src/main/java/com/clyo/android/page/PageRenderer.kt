package com.clyo.android.page

import android.content.Context
import com.clyo.android.component.container.Container
import com.clyo.android.component.container.ContainerData
import com.clyo.android.component.container.ContainerProvider
import com.clyo.android.component.type.ComponentType
import com.clyo.android.component.widget.Widget
import com.clyo.android.component.widget.WidgetProvider
import com.clyo.android.data.PageData

internal class PageRenderer(
    private val widgetProvider: WidgetProvider,
    private val containerProvider: ContainerProvider,
) {
    fun create(context: Context, pageData: PageData): Page {
        return Page(container(context, pageData.content))
    }

    private fun container(
        context: Context,
        containerData: ContainerData
    ): Container<*> = containerProvider.provideByTypeWithContent(
        context = context,
        type = containerData.type,
        content = widgets(context, containerData.widgetsType())
    )

    private fun widgets(
        context: Context,
        widgets: List<ComponentType>
    ): List<Widget<*, *>> = widgets.map { widgetType ->
        widgetProvider.provideByType(context, widgetType)
    }
}

private fun ContainerProvider.provideByTypeWithContent(
    context: Context,
    type: ComponentType,
    content: List<Widget<*, *>>
): Container<*> = provideByType(context, type).apply {
    addAll(content)
}

private fun ContainerData.widgetsType(): List<ComponentType> = content.map { it.type }