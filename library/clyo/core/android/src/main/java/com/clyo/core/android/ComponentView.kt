package com.clyo.core.android

import android.content.Context
import android.view.View
import com.eliascoelho911.clyo.ComponentData
import com.eliascoelho911.clyo.ComponentName
import com.eliascoelho911.clyo.ComponentProperties

typealias ComponentView = View

abstract class ComponentViewCreator {
    protected abstract val componentName: ComponentName

    internal fun isExpectedComponent(componentName: ComponentName): Boolean =
        this.componentName == componentName

    fun validateAndCreate(context: Context, data: ComponentData): ComponentView {
        return if (isExpectedComponent(componentName)) {
            create(context, data.properties)
        } else error("Could not create $componentName because the data received is from the component ${data.name}")
    }

    abstract fun create(context: Context, properties: ComponentProperties): ComponentView
}

internal fun Collection<ComponentViewCreator>.findCreatorToComponent(
    componentName: ComponentName
): ComponentViewCreator {
    val creatorsFound = filter { it.isExpectedComponent(componentName) }

    if (creatorsFound.isEmpty()) {
        error("$componentName component creator not found")
    } else if (creatorsFound.size > 1) {
        error("Multiple creators found for component $componentName")
    }

    return creatorsFound.first()
}