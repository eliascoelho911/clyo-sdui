package com.clyo.ui

import com.clyo.ui.internal.ViewRenderer
import com.clyo.ui.internal.module.ViewClassModule

/**
 * Prover a instância atual de [Clyo]
 */
internal object ClyoProvider {
    private var mClyo: Clyo? = null

    fun getOrCreate(): Clyo {

    }

    fun get() {

    }

    fun create() {
        val viewRenderer = createViewRenderer()
        mClyo = Clyo(viewRenderer)
    }

    private fun createViewRenderer(viewClassModule: ViewClassModule): ViewRenderer {
        val viewClassModule = ViewClassModule()
        return ViewRenderer(

        )
    }
}