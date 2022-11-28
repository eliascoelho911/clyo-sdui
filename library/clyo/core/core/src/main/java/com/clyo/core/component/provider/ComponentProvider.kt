package com.clyo.core.component.provider

import android.content.Context
import com.clyo.core.component.Component
import com.clyo.core.data.ComponentData

class ComponentProvider<DATA : ComponentData, COMPONENT : Component>(
    private val component: (context: Context, data: DATA) -> COMPONENT
) {
    fun provide(context: Context, data: DATA): COMPONENT = component(context, data)
}