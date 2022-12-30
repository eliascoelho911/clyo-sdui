package com.clyo.android.view

import android.view.View
import com.clyo.core.data.ViewProperties

interface ViewBinder<T : View> {
    fun bind(view: T, properties: ViewProperties)
}