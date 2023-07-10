package com.clyo.android.ui.component.container

import android.content.Context

interface ContainerProvider {
    fun provideInstanceByType(context: Context, type: String): Container<*>
}