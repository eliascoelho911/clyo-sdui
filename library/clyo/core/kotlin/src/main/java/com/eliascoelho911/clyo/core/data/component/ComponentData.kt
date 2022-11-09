package com.eliascoelho911.clyo.core.data.component

import com.eliascoelho911.clyo.core.component.Component
import com.eliascoelho911.clyo.core.findComponentFactory
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement

@Serializable
data class ComponentData(
    @SerialName("key") val key: String,
    @SerialName("properties") val properties: JsonObject
) {
    inline fun <reified T : Any> getPropertyByKey(key: String): T {
        val propertyValue = properties[key]
        requireNotNull(propertyValue)
        return Json.decodeFromJsonElement(propertyValue)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Component> createComponent(componentClazz: KClass<T>): T {
        requireFromComponent(componentClazz)

        return findComponentFactory(key)?.create(this) as? T
            ?: error("ComponentFactory of component $key was not registered")
    }

    private fun requireFromComponent(componentClazz: KClass<*>) {
        require(componentClazz.hasAnnotation<DeclareComponent>())

        componentClazz.findAnnotation<DeclareComponent>().let { component ->
            requireNotNull(component)
            require(component.key == key)
        }
    }
}