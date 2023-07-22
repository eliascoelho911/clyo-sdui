package com.clyo.android.component

import android.content.Context
import android.view.View
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

abstract class Widget<V : View, A : ComponentArgs> : ViewComponent<V> {
    abstract fun updateArgs(args: A)

    @Suppress("UNCHECKED_CAST")
    fun updateArgsWithCast(componentArgs: ComponentArgs) {
        updateArgs(componentArgs as A)
    }
}

@Serializable
data class WidgetData(
    @SerialName("type")
    @Serializable(with = ComponentTypeSerializer::class)
    val type: ComponentType,
    @SerialName("args")
    val args: ComponentArgs
)

interface WidgetProvider {
    fun provideByType(context: Context, type: ComponentType): Widget<*, *>
}