package com.clyo.core.component

import android.view.View
import com.clyo.core.data.ComponentProperties

open class Component<VIEW : View> internal constructor(
    val view: VIEW,
    val properties: ComponentProperties
) {
    fun bind(block: VIEW.(properties: ComponentProperties) -> Unit) {
        view.block(properties)
    }
}