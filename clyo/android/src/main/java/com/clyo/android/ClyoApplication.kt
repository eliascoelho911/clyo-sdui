package com.clyo.android

import com.clyo.android.container.ContainerProvider
import com.clyo.android.widget.WidgetProvider
import com.clyo.component.properties.WidgetProperties
import com.clyo.json.JsonInstanceFactory
import kotlin.reflect.KClass
import kotlinx.serialization.KSerializer

object ClyoApplication {
    lateinit var clyo: Clyo

    inline fun <reified T : WidgetProperties> start(
        widgetProvider: WidgetProvider,
        containerProvider: ContainerProvider,
        widgetPropertiesKSerializerMap: Map<KClass<T>, KSerializer<T>>
    ) {
        val json = JsonInstanceFactory.create(widgetPropertiesKSerializerMap)
        this.clyo = Clyo(widgetProvider, containerProvider, json)
    }
}