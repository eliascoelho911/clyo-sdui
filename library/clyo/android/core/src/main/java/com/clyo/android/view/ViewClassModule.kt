package com.clyo.android.view

import android.view.View
import com.clyo.core.data.ViewName
import com.clyo.core.util.Module
import kotlin.reflect.KClass

/**
 * Essa classe é responsável por armazenar e prover [KClass] da [View] com a key [ViewName]
 */
class ViewClassModule : Module<ViewName, KClass<out View>>()
