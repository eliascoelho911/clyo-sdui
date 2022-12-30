package com.clyo.android.view

import android.view.View
import com.clyo.core.data.ViewName
import com.clyo.core.util.Registry
import kotlin.reflect.KClass

internal class ViewClassRegistry : Registry<ViewName, KClass<out View>, ViewClassModule>() {
    override val module = ViewClassModule()
}