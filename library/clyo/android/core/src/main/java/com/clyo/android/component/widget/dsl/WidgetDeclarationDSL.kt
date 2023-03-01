package com.clyo.android.component.widget.dsl

import android.view.View
import com.clyo.android.component.ComponentModule
import com.clyo.android.component.ComponentName
import com.clyo.android.component.widget.WidgetBinder
import com.clyo.android.properties.AbstractPropertiesData

class WidgetDeclarationDSL<T : View> @PublishedApi internal constructor(
    private val name: ComponentName,
    private val componentModule: ComponentModule
) {
    fun binder(block: T.(properties: AbstractPropertiesData) -> Unit) {
        componentModule.putComponentBinder(name) { WidgetBinder(block) }
    }
}