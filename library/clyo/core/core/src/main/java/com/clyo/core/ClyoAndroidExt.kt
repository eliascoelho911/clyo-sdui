package com.clyo.core

import android.app.Activity
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

fun Activity.startClyo(@IdRes rootId: Int) {
    Clyo.start(
        screenRenderer = AndroidScreenRenderer(
            rootView = findViewById(rootId)
        )
    )
}

fun Fragment.startClyo() {
    Clyo.start(
        screenRenderer = AndroidScreenRenderer(
            rootView = requireView() as? ViewGroup ?: error("The root view must be a ViewGroup")
        )
    )
}