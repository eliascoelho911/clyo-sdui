package com.clyo.android.component.widget.dsl

import android.view.View
import com.clyo.android.component.ComponentName
import com.clyo.android.component.widget.WidgetBinder
import com.clyo.android.component.widget.WidgetModule
import com.clyo.android.properties.AbstractPropertiesData

class WidgetDeclarationDSL<T : View> @PublishedApi internal constructor(
    private val name: ComponentName,
    private val widgetModule: WidgetModule
) {
    fun binder(block: T.(properties: AbstractPropertiesData) -> Unit) {
        widgetModule.putBinder(name) { WidgetBinder(block) }
    }
}