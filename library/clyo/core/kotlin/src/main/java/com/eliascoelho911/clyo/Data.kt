package com.eliascoelho911.clyo

data class ScreenData(
    val content: LayoutData
)

interface LayoutData : ComponentData {
    val content: List<ComponentData>
}

interface ComponentData {
    val name: ComponentName
    val properties: ComponentProperties
}

typealias ComponentName = String

class ComponentProperties(
    private val properties: Map<String, Any> = emptyMap()
) {
    fun <T> get(key: String): T {
        val value = properties[key]
        requireNotNull(value)

        return getOrNull(key)
            ?: throw ClassCastException("cannot cast property $key because it is of type ${value::class.java.simpleName}")
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getOrNull(key: String): T? {
        return properties[key] as? T
    }
}