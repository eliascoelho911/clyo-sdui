package com.clyo.viewclass

import android.view.View
import com.clyo.data.ViewName
import com.clyo.util.Registry
import kotlin.reflect.KClass

internal class ViewClassRegistry : Registry<ViewName, KClass<out View>, ViewClassModule>() {
    override val module = ViewClassModule()
}