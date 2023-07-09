package com.clyo.android.widget

import android.content.Context
import android.view.View
import com.clyo.android.common.newInstance
import com.clyo.data.properties.Properties
import kotlin.reflect.KClass

class WidgetBuilder<VIEW : View, PROP : Properties> internal constructor() {
    private lateinit var view: VIEW
    private lateinit var binder: WidgetBinder<VIEW, PROP>

    fun view(context: Context, viewKClass: KClass<VIEW>): WidgetBuilder<VIEW, PROP> {
        return apply { this.view = viewKClass.newInstance(context) }
    }

    fun binder(binder: WidgetBinder<VIEW, PROP>): WidgetBuilder<VIEW, PROP> {
        return apply { this.binder = binder }
    }

    internal fun build() = Widget(view, binder)
}

fun <VIEW : View, PROP : Properties> widget(
    block: WidgetBuilder<VIEW, PROP>.() -> Unit
): Widget<VIEW, PROP> {
    return WidgetBuilder<VIEW, PROP>().apply(block).build()
}