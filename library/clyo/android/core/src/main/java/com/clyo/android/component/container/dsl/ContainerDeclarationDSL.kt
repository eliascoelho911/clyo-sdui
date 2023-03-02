package com.clyo.android.component.container.dsl

import android.view.View
import com.clyo.android.component.ComponentName
import com.clyo.android.component.container.ContainerBinder
import com.clyo.android.component.container.ContainerModule
import com.clyo.android.properties.AbstractPropertiesData

class ContainerDeclarationDSL<T : View> @PublishedApi internal constructor(
    private val name: ComponentName,
    private val containerModule: ContainerModule
) {
    fun binder(block: T.(properties: AbstractPropertiesData) -> Unit) {
        containerModule.putBinder(name) { ContainerBinder(block) }
    }
}