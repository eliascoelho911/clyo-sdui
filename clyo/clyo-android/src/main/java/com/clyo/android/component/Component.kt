package com.clyo.android.component

import android.view.View

/**
 * Base class for all components.
 * @param T the type of the view associated with the component.
 */
abstract class Component<T : View, Data : ComponentData> {

    internal abstract val view: T

    /**
     * Render the component with the given data.
     * @param data the data to render the component.
     */
    abstract fun render(data: Data)

    internal fun applyOnView(block: T.() -> Unit) {
        return view.block()
    }
}