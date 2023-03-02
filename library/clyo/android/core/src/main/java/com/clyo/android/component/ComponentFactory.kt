package com.clyo.android.component

import android.content.Context
import android.view.View

internal interface ComponentFactory {
    fun create(context: Context, name: ComponentName): Component<out View>
}