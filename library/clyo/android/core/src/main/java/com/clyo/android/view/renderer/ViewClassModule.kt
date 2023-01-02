package com.clyo.android.view.renderer

import android.view.View
import com.clyo.android.ViewName
import com.clyo.core.Module
import kotlin.reflect.KClass

internal typealias ViewClassModule = Module<ViewName, KClass<out View>>