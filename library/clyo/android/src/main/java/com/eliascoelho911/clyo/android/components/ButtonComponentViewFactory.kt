package com.eliascoelho911.clyo.android.components

import android.content.Context
import android.widget.Button
import com.clyo.core.android.ComponentViewFactory
import com.clyo.core.android.annotation.DeclareComponentFactory
import com.eliascoelho911.clyo.ComponentProperties

@DeclareComponentFactory("android.button")
internal class ButtonComponentViewFactory : ComponentViewFactory<Button>() {
    override fun createInstance(context: Context) = Button(context)

    override fun Button.bind(properties: ComponentProperties): Button = apply {
        text = properties.get("text")
    }
}