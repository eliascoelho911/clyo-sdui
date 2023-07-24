package com.clyo.component

import android.view.ViewGroup

interface Container<V : ViewGroup, T : Any> : Component<V>, Layout<V, T>

interface Layout<V : ViewGroup, T : Any> {
    val content: List<T>
    fun add(widget: T)
    fun addAll(widgets: List<T>)
    fun remove(index: Int)
    fun clear()
}