package com.clyo.android.ui

import android.view.View

interface ViewComponent<VIEW : View> {

    // Todo: Transformar em lazy
    val view: VIEW
}