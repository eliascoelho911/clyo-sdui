package com.clyo.ui.internal.module

import android.view.View
import com.clyo.data.ViewName
import com.clyo.ui.ViewBinder

/**
 * Essa classe é responsável por armazenar e prover [ViewBinder] da [View] com a key [ViewName]
 */
internal class ViewBinderModule: LocalModule<ViewName, ViewBinder<*>>()
