package com.clyo.android.page

import android.content.Context
import android.view.View
import com.clyo.android.container.AndroidContainer
import com.clyo.android.container.ContainerData
import com.clyo.android.container.ContainerProvider
import com.clyo.android.widget.AndroidWidget
import com.clyo.android.widget.WidgetData
import com.clyo.android.widget.WidgetProvider
import com.clyo.component.properties.Properties
import com.clyo.component.properties.WidgetProperties

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
    ): AndroidContainer<*> = containerProvider.provideByType(
        context = context,
        type = containerData.type
    ).addContent(getWidgets(context, containerData.content))

    private fun getWidgets(
        context: Context,
        widgets: List<WidgetData>
    ): List<AndroidWidget<*, *>> = widgets.map { widgetData ->
        getWidget(context, widgetData).bind(widgetData.args)
    }

    private fun getWidget(
        context: Context,
        widgetData: WidgetData
    ): AndroidWidget<*, *> = widgetProvider.provideByType(context, widgetData.type)
}

private fun AndroidContainer<*>.addContent(
    content: List<AndroidWidget<*, *>>
): AndroidContainer<*> = apply { addAll(content) }

@Suppress("UNCHECKED_CAST")
private fun <V : View, P : WidgetProperties> AndroidWidget<V, P>.bind(
    properties: Properties
): AndroidWidget<V, P> = apply { bind(properties as P) }
