package com.clyo.android.component.provider

import android.content.Context
import com.clyo.android.component.Component

interface ComponentProvider {
    fun provide(context: Context, type: String): Component<*, *>
}