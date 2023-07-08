package com.clyo.android.widget

import android.content.Context
import android.view.View
import com.clyo.android.common.newInstance
import kotlin.reflect.KClass

class WidgetBuilder<T : View> internal constructor() {
    private lateinit var view: T
    private lateinit var binder: WidgetBinder<T>

    fun view(context: Context, viewKClass: KClass<T>) =
        apply { this.view = viewKClass.newInstance(context) }

    fun binder(binder: WidgetBinder<T>) = apply { this.binder = binder }

    internal fun build() = Widget(view, binder)
}

fun <T : View> widget(block: WidgetBuilder<T>.() -> Unit): Widget<T> {
    return WidgetBuilder<T>().apply(block).build()
}