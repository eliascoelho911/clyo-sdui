package com.clyo.core.android

import android.content.Context
import com.eliascoelho911.clyo.data.ComponentData
import com.eliascoelho911.clyo.data.ComponentName
import com.eliascoelho911.clyo.data.ComponentProperties

abstract class ComponentViewCreator {
    protected abstract val componentName: ComponentName

    internal fun isExpectedComponent(componentName: ComponentName): Boolean =
        this.componentName == componentName

    fun validateAndCreate(context: Context, data: ComponentData): ComponentView {
        return if (isExpectedComponent(componentName)) {
            create(context, data.properties)
        } else error("could not create $componentName with received data")
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
        error("multiple creators found for component $componentName")
    }

    return creatorsFound.first()
}