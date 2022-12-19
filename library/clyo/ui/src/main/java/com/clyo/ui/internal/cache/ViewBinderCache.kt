package com.clyo.ui.internal.cache

import android.view.View
import com.clyo.data.ViewName
import com.clyo.ui.ViewBinder

/**
 * Essa classe é responsável por armazenar e prover [ViewBinder] da [View] com a key [ViewName]
 */
internal class ViewBinderCache: LocalCache<ViewName, ViewBinder<*>>()
