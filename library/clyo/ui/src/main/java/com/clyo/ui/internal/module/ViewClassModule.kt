package com.clyo.ui.internal.module

import android.view.View
import com.clyo.data.ViewName
import kotlin.reflect.KClass

/**
 * Essa classe é responsável por armazenar e prover [KClass] da [View] com a key [ViewName]
 */
internal class ViewClassModule : LocalModule<ViewName, KClass<out View>>()
