package com.clyo.android.component.widget

import android.view.View
import com.clyo.android.component.Component

internal class Widget<T : View>(
    override val view: T,
    override val binder: WidgetBinder<T>
) : Component<T>()