package com.clyo.android.component

import android.view.View

sealed interface Component<V : View> {
    val view: V
}