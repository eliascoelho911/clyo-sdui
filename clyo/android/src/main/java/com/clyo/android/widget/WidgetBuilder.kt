package com.clyo.android.widget

import android.view.View
import kotlin.reflect.KClass

class WidgetBuilder<T : View> internal constructor() {
    private lateinit var viewKClass: KClass<T>
    private lateinit var binder: WidgetBinder<T>

    fun view(viewKClass: KClass<T>) = apply { this.viewKClass = viewKClass }

    fun binder(binder: WidgetBinder<T>) = apply { this.binder = binder }

    internal fun build() = Widget(viewKClass, binder)
}

fun <T : View> widget(block: WidgetBuilder<T>.() -> Unit): Widget<T> {
    return WidgetBuilder<T>().apply(block).build()
}