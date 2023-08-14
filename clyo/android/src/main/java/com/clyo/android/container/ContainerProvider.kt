package com.clyo.android.container

import android.content.Context
import com.clyo.android.component.Container
import com.clyo.component.type.ComponentType

interface ContainerProvider {
    fun provideByType(context: Context, type: ComponentType): Container<*>
}