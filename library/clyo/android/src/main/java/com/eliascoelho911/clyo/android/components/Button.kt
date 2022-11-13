package com.eliascoelho911.clyo.android.components

import android.content.Context
import android.widget.Button
import com.clyo.core.android.ComponentView
import com.clyo.core.android.ComponentViewCreator
import com.eliascoelho911.clyo.data.ComponentName
import com.eliascoelho911.clyo.data.ComponentProperties

object ButtonViewCreator : ComponentViewCreator() {
    override val componentName: ComponentName = "android.button"

    override fun create(context: Context, properties: ComponentProperties): ComponentView {
        return Button(context).apply {
            text = properties["text"]?.content ?: error("property text not found")
        }
    }
}