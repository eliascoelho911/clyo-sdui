package com.clyo.android.component

import android.view.View

sealed interface ViewComponent<VIEW : View> : Component {
    val view: VIEW
}