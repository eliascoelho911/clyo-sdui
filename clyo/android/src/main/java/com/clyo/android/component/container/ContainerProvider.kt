package com.clyo.android.component.container

import android.content.Context
import com.clyo.android.component.type.ComponentType
import com.clyo.android.component.widget.Widget

interface ContainerProvider {
    fun provideByType(context: Context, type: ComponentType): Container<*>
}