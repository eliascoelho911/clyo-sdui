package com.clyo.json

import com.clyo.component.properties.WidgetProperties
import kotlin.reflect.KClass
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

object JsonInstanceFactory {
    inline fun <reified T : WidgetProperties> create(widgetPropertiesKSerializerMap: Map<KClass<T>, KSerializer<T>>): Json {
        return Json {
            ignoreUnknownKeys = true
            serializersModule = SerializersModule {
                widgetPropertiesKSerializerMap.forEach { (widgetPropertiesClass, widgetPropertiesSerializer) ->
                    polymorphic(WidgetProperties::class) {
                        subclass(widgetPropertiesClass, widgetPropertiesSerializer)
                    }
                }
            }
        }
    }
}