package com.clyo.android.page

import android.content.Context
import android.view.View
import com.clyo.android.components.Container
import com.clyo.android.components.Widget
import com.clyo.component.container.ContainerData
import com.clyo.android.container.ContainerProvider
import com.clyo.component.widget.WidgetData
import com.clyo.android.widget.WidgetProvider
import com.clyo.component.properties.Properties
import com.clyo.component.properties.WidgetProperties
import com.clyo.page.PageData

internal class PageFactory(
    private val widgetProvider: WidgetProvider,
    private val containerProvider: ContainerProvider,
) {
    fun create(context: Context, pageData: PageData): Page {
        return Page(getContainer(context, pageData.content))
    }

    private fun getContainer(
        context: Context,
        containerData: ContainerData
    ): Container<*> = containerProvider.provideByType(
        context = context,
        type = containerData.type
    ).addContent(getWidgets(context, containerData.content))

    private fun getWidgets(
        context: Context,
        widgets: List<WidgetData>
    ): List<Widget<*, *>> = widgets.map { widgetData ->
        getWidget(context, widgetData).bind(widgetData.args)
    }

    private fun getWidget(
        context: Context,
        widgetData: WidgetData
    ): Widget<*, *> = widgetProvider.provideByType(context, widgetData.type)
}

private fun Container<*>.addContent(
    content: List<Widget<*, *>>
): Container<*> = apply { addAll(content) }

@Suppress("UNCHECKED_CAST")
private fun <V : View, P : WidgetProperties> Widget<V, P>.bind(
    properties: Properties
): Widget<V, P> = apply { bind(properties as P) }
