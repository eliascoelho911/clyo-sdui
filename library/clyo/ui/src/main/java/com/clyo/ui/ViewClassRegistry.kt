package com.clyo.ui

import android.view.View
import com.clyo.data.ViewName
import com.clyo.ui.internal.module.ViewClassModule
import kotlin.reflect.KClass

internal class ViewClassRegistry : Registry<ViewName, KClass<out View>, ViewClassModule>() {
    override val module = ViewClassModule()
}