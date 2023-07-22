package com.clyo.android.page

import android.content.Context
import com.clyo.android.component.ComponentArgs
import com.clyo.android.component.ComponentType
import com.clyo.android.component.Container
import com.clyo.android.component.ContainerData
import com.clyo.android.component.ContainerProvider
import com.clyo.android.component.Widget
import com.clyo.android.component.WidgetData
import com.clyo.android.component.WidgetProvider

internal class PageFactory(
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
        content = widgets(context, containerData.content)
    )

    private fun widgets(
        context: Context,
        widgets: List<WidgetData>
    ): List<Widget<*, *>> = widgets.map { widgetData ->
        widgetProvider.provideByType(context, widgetData.type).submitArgs(widgetData.args)
    }
}

private fun ContainerProvider.provideByTypeWithContent(
    context: Context,
    type: ComponentType,
    content: List<Widget<*, *>>
): Container<*> = provideByType(context, type).apply {
    addAll(content)
}

private fun Widget<*, *>.submitArgs(args: ComponentArgs) = apply {
    updateArgsWithCast(args)
}