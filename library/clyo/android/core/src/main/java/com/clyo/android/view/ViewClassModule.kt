package com.clyo.android.view

import android.view.View
import com.clyo.core.data.WidgetName
import com.clyo.core.util.Module
import kotlin.reflect.KClass

/**
 * Essa classe é responsável por armazenar e prover [KClass] da [View] com a key [WidgetName]
 */
class ViewClassModule : Module<WidgetName, KClass<out View>>()
