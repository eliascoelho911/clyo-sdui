package com.clyo.sample.impl.container

import android.content.Context
import com.clyo.android.component.Container
import com.clyo.android.container.ContainerProvider
import com.clyo.component.type.ComponentType
import com.clyo.sample.presentation.components.containers.Column

internal class ContainerProviderImpl : ContainerProvider {
    override fun provideByType(context: Context, type: ComponentType): Container<*> {
        return when (type.type) {
            "column" -> Column(context)
            else -> throw IllegalArgumentException("Unknown type: $type")
        }
    }
}