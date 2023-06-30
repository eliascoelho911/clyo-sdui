package com.clyo.android.sample

import android.content.Context
import com.clyo.android.component.Component
import com.clyo.android.component.provider.ComponentProvider

class SampleComponentProvider : ComponentProvider {
    override fun provide(context: Context, type: String): Component<*, *> {
        return when (type) {
            "Text" -> Text(context)
            else -> throw IllegalArgumentException("No component found for type $type")
        }
    }
}