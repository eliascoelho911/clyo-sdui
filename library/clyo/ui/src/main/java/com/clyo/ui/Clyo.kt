package com.clyo.ui

import com.clyo.ui.internal.ViewBinderInteractor
import com.clyo.ui.internal.ViewRenderer

/**
 * Deve servir como um contexto / escopo para a aplicação Clyo.
 */
internal class Clyo {
    internal val viewRenderer: ViewRenderer = ViewRenderer(
        viewClassModule = ViewClassModuleProvider.get(),
        viewBinderRobot = ViewBinderInteractor(
            viewBinderCache = ViewBinderCacheModuleProvider.get()
        )
    )
}

internal fun getClyo(): Clyo = ClyoProvider.getOrCreate()