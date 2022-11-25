package com.clyo.android.material.components

import com.clyo.core.component.renderer.widgetRenderer
import com.clyo.core.component.renderer.widgetRendererModule
import com.google.android.material.button.MaterialButton

val Material3WidgetRendererModule = widgetRendererModule {
    widgetRenderer<MaterialButton>("button") {
        text = it.properties.getStringOrNull("text")
    }
}
