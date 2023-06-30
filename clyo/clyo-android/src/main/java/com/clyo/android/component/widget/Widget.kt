package com.clyo.android.component.widget

import android.view.View
import com.clyo.android.component.Component
import com.clyo.android.component.ComponentData

/**
 * Base class for all widgets.
 * @param T the type of the view associated with the widget.
 * @see Component
 */
abstract class Widget<T : View, Data : ComponentData> : Component<T, Data>()