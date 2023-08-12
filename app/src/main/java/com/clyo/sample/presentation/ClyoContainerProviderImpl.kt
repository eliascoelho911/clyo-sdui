package com.clyo.sample.presentation

import android.content.Context
import com.clyo.android.components.Container
import com.clyo.android.container.ContainerProvider
import com.clyo.component.type.ComponentType
import com.clyo.sample.presentation.components.containers.Column

class ClyoContainerProviderImpl : ContainerProvider {
    override fun provideByType(context: Context, type: ComponentType): Container<*> {
        return when (type.type) {
            "column" -> Column(context)
            else -> throw IllegalArgumentException("Unknown type: $type")
        }
    }
}