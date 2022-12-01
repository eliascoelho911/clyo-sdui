package com.clyo.core.component

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.clyo.core.data.ComponentProperties

open class ComponentBuilder<T : View> {
    protected lateinit var viewLazy: (context: Context) -> T

    protected var bindBlock: T.(properties: ComponentProperties) -> Unit = {}

    fun view(view: (context: Context) -> T) = apply {
        viewLazy = view
    }

    fun bind(bind: T.(properties: ComponentProperties) -> Unit) = apply {
        bindBlock = bind
    }

    open fun build(context: Context, properties: ComponentProperties) = Component(
        view = viewLazy(context),
        properties = properties
    ).apply { bind(bindBlock) }
}

class ContainerBuilder<T : ViewGroup> : ComponentBuilder<T>() {
    private val content: MutableList<Component<*>> = mutableListOf()

    fun withContent(content: List<Component<*>>) = apply {
        this.content.apply {
            clear()
            addAll(content)
        }
    }

    override fun build(context: Context, properties: ComponentProperties) = Container(
        viewGroup = viewLazy(context),
        properties = properties
    ).apply {
        bind(bindBlock)
        addContent(content)
    }
}