package com.clyo.android

import android.view.ViewGroup
import com.clyo.android.component.container.BaseContainerData
import com.clyo.android.component.container.Container
import com.clyo.android.component.container.ContainerFactory
import com.clyo.android.component.widget.BaseWidgetData
import com.clyo.android.component.widget.WidgetFactory

internal class ClyoRenderer(
    private val widgetFactory: WidgetFactory,
    private val containerFactory: ContainerFactory
) {
    fun render(data: BaseClyoData, parent: ViewGroup) {
        return render(parent, data.root)
    }

    private fun render(parent: ViewGroup, containerData: BaseContainerData) {
        val container = containerFactory.setup(parent.context, containerData)

        container.addAllWidgets(containerData.content)

        parent.addView(container.view)
    }

    private fun Container<*>.addAllWidgets(content: List<BaseWidgetData>) {
        content.forEach { widgetData ->
            val widget = widgetFactory.setup(
                context = view.context,
                data = widgetData
            )

            addWidget(widget, widgetData.layoutProperties)
        }
    }
}