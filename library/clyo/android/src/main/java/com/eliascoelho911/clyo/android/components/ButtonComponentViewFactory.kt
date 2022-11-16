package com.eliascoelho911.clyo.android.components

import android.content.Context
import android.widget.Button
import com.clyo.core.android.ComponentViewFactory
import com.clyo.core.android.annotation.DeclareComponentViewFactory
import com.eliascoelho911.clyo.ComponentProperties

@DeclareComponentViewFactory("android.button")
internal class ButtonComponentViewFactory : ComponentViewFactory<Button>() {
    override fun create(context: Context, properties: ComponentProperties): Button {
        return Button(context).apply {
            text = properties.get("text")
        }
    }
}