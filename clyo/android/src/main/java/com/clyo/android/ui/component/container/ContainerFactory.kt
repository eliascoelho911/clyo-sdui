package com.clyo.android.ui.component.container

import android.content.Context
import com.clyo.android.ui.component.widget.WidgetFactory
import com.clyo.data.container.ContainerJson

interface ContainerFactory {

    val widgetFactory: WidgetFactory

    fun create(context: Context, json: ContainerJson): Container<*> {
        val layout = provideInstanceByType(context, json.type)

        json.content.forEach { widgetJson ->
            layout.add(widgetFactory.provideInstanceByType(context, widgetJson.type))
        }

        return layout
    }

    fun provideInstanceByType(context: Context, type: String): Container<*>
}