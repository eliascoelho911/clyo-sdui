package com.clyo.android.component

import android.view.View

interface ViewComponent<VIEW : View> : Component {
    val view: VIEW
}