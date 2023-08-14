package com.clyo.android.page

import android.content.Context
import android.view.View
import com.clyo.android.component.Container
import com.clyo.android.component.Widget
import com.clyo.android.container.ContainerProvider
import com.clyo.android.widget.WidgetProvider
import com.clyo.component.container.ContainerData
import com.clyo.component.properties.Properties
import com.clyo.component.properties.WidgetProperties
import com.clyo.component.widget.WidgetData
import com.clyo.page.ContainerPageData

internal class ContainerPageFactory(
    private val context: Context,
    private val widgetProvider: WidgetProvider,
    private val containerProvider: ContainerProvider,
) {
    fun create(containerPageData: ContainerPageData): ContainerPage {
        return ContainerPage(container(containerData = containerPageData.content))
    }

    private fun container(containerData: ContainerData): Container<*> {
        return containerProvider.provideByType(
            context, type = containerData.type
        ).addContent(widgets(widgets = containerData.content))
    }

    private fun widgets(widgets: List<WidgetData>): List<Widget<*, *>> {
        return widgets.map { widgetData ->
            getWidget(widgetData).bind(properties = widgetData.properties)
        }
    }

    private fun getWidget(widgetData: WidgetData): Widget<*, *> {
        return widgetProvider.provideByType(context, type = widgetData.type)
    }
}

private fun Container<*>.addContent(
    content: List<Widget<*, *>>
): Container<*> = apply { addAll(content) }

@Suppress("UNCHECKED_CAST")
private fun <V : View, P : WidgetProperties> Widget<V, P>.bind(
    properties: Properties
): Widget<V, P> = apply { bind(properties as P) }
