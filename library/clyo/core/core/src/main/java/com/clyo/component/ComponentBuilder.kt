package com.clyo.component

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.clyo.data.ViewProperties

open class ComponentBuilder<T : View> {
    protected lateinit var viewLazy: (context: Context) -> T

    protected var bindBlock: T.(properties: ViewProperties) -> Unit = {}

    fun view(view: (context: Context) -> T) = apply {
        viewLazy = view
    }

    fun bind(bind: T.(properties: ViewProperties) -> Unit) = apply {
        bindBlock = bind
    }

    open fun build(context: Context, properties: ViewProperties) = Component(
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

    override fun build(context: Context, properties: ViewProperties) = Container(
        viewGroup = viewLazy(context),
        properties = properties
    ).apply {
        bind(bindBlock)
        addContent(content)
    }
}