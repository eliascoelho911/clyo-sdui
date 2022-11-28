package com.clyo.core.component.provider

import android.content.Context
import com.clyo.core.component.Component
import com.clyo.core.component.ComponentModule
import com.clyo.core.component.Container
import com.clyo.core.data.ComponentData
import com.clyo.core.data.ComponentName
import com.clyo.core.data.ContainerData

fun <COMPONENT : Component> ComponentModule.component(
    name: ComponentName,
    builder: (context: Context, data: ComponentData) -> COMPONENT
) = ComponentProvider(builder).also { add(name, it) }

fun <CONTAINER : Container> ComponentModule.container(
    name: ComponentName,
    builder: (context: Context, data: ContainerData) -> CONTAINER
) = ComponentProvider(builder).also { add(name, it) }