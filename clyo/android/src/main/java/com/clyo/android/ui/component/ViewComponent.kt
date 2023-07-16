package com.clyo.android.ui.component

import android.view.View

interface ViewComponent<VIEW : View> {
    val view: VIEW
}