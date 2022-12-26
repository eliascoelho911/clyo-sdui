package com.clyo.viewclass

import android.view.View
import com.clyo.data.ViewName
import com.clyo.util.Module
import kotlin.reflect.KClass

/**
 * Essa classe é responsável por armazenar e prover [KClass] da [View] com a key [ViewName]
 */
class ViewClassModule : Module<ViewName, KClass<out View>>()
