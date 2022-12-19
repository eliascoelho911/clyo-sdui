package com.clyo.ui.internal.module

import android.view.View
import com.clyo.data.ViewName
import kotlin.reflect.KClass

/**
 * Essa classe é responsável por armazenar e prover [KClass] da [View] com a key [ViewName]
 */
class ViewClassModule : Module<ViewName, KClass<out View>>()
