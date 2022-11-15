package com.clyo.core.android

import android.content.Context
import android.view.View
import com.eliascoelho911.clyo.ComponentProperties

typealias ComponentView = View

abstract class ComponentViewFactory<T : ComponentView> {
    abstract fun create(context: Context, properties: ComponentProperties): T
}