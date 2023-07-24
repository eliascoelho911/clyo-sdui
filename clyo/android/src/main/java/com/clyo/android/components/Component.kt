package com.clyo.android.components

import android.view.View

sealed interface Component<V : View> {
    val view: V
}