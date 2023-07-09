package com.clyo.android.ui.layout

import android.content.Context

interface LayoutProvider {
    fun provide(context: Context, type: String): Layout<*>
}