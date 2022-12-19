package com.clyo.ui

import android.view.View
import com.clyo.data.ViewProperties

interface ViewBinder<T : View> {
    fun bind(view: T, properties: ViewProperties): T
}