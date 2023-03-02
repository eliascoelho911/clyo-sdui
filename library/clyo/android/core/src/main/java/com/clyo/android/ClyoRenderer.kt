package com.clyo.android

import android.view.ViewGroup
import com.clyo.android.component.container.AbstractContainerData
import com.clyo.android.component.container.Container
import com.clyo.android.component.container.ContainerFactory
import com.clyo.android.component.widget.AbstractWidgetData
import com.clyo.android.component.widget.WidgetFactory

internal class ClyoRenderer(
    private val widgetFactory: WidgetFactory,
    private val containerFactory: ContainerFactory
) {
    fun render(data: AbstractClyoData, parent: ViewGroup) {
        return render(parent, data.root)
    }

    //Todo Simplificar código reduzindo duplicação
    private fun render(parent: ViewGroup, containerData: AbstractContainerData) {
        val container = createContainer(parent, containerData)
        parent.addView(container.view)

        containerData.content.forEach { widgetData ->
            showWidget(container, widgetData)
        }
    }

    private fun createContainer(
        parent: ViewGroup,
        containerData: AbstractContainerData
    ): Container<*> {
        return containerFactory.create(parent.context, containerData.name).also {
            it.bind(containerData.properties)
        }
    }

    private fun showWidget(container: Container<*>, widgetData: AbstractWidgetData) {
        widgetFactory.create(container.view.context, widgetData.name).also {
            it.bind(widgetData.properties)
        }.let { container.addWidget(it, widgetData.layoutProperties) }
    }
}