package com.clyo.android.component.widget

import android.view.View
import com.clyo.android.component.ViewComponent
import com.clyo.android.component.args.ComponentArgs

abstract class Widget<V : View, A : ComponentArgs> : ViewComponent<V> {
    abstract fun updateArgs(args: A)

    @Suppress("UNCHECKED_CAST")
    fun updateArgsWithCast(componentArgs: ComponentArgs) {
        updateArgs(componentArgs as A)
    }
}