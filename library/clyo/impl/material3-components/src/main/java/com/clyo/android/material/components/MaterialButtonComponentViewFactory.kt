package com.clyo.android.material.components

import android.content.Context
import com.clyo.core.component.ComponentViewFactory
import com.clyo.core.component.DeclareComponentFactory
import com.clyo.core.data.ComponentProperties
import com.google.android.material.button.MaterialButton

@DeclareComponentFactory("button")
internal class MaterialButtonComponentViewFactory : ComponentViewFactory<MaterialButton>() {
    override fun createInstance(context: Context) = MaterialButton(context)

    override fun MaterialButton.bind(properties: ComponentProperties): MaterialButton = apply {
        text = properties.get("text")
    }
}