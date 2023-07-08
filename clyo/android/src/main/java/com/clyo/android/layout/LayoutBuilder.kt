package com.clyo.android.layout

import android.content.Context
import android.view.ViewGroup
import com.clyo.android.common.newInstance
import kotlin.reflect.KClass

class LayoutBuilder<T : ViewGroup> internal constructor() {
    private lateinit var viewGroup: T

    fun layout(context: Context, viewKClass: KClass<T>) =
        apply { this.viewGroup = viewKClass.newInstance(context) }

    internal fun build() = Layout(viewGroup)
}

fun <T : ViewGroup> layout(block: LayoutBuilder<T>.() -> Unit): Layout<T> {
    return LayoutBuilder<T>().apply(block).build()
}