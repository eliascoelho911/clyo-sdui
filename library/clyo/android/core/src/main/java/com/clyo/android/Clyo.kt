package com.clyo.android

import android.content.Context
import com.clyo.android.view.renderer.ViewBinderInteractor
import com.clyo.android.view.renderer.ViewBinderModule
import com.clyo.android.view.renderer.ViewClassModule
import com.clyo.android.view.renderer.ViewInstantiator
import com.clyo.android.view.renderer.ViewRenderer
import com.clyo.core.Clyo
import com.clyo.core.ClyoComponent
import com.clyo.core.data.ClyoData

/**
 * Representa a aplicação de Clyo no Android. Instancia deve ser criada dentro de um [ClyoComponent]
 */
class ClyoAndroid internal constructor(
    context: Context,
    viewBinderModule: ViewBinderModule = ViewBinderModule(),
    viewClassModule: ViewClassModule = ViewClassModule()
) : Clyo {

    private val viewRenderer: ViewRenderer = ViewRenderer(
        context = context,
        viewInstantiator = ViewInstantiator(viewClassModule),
        viewBinderInteractor = ViewBinderInteractor(viewBinderModule)
    )

    override fun render(data: ClyoData) {
        viewRenderer.render(data.root)
    }
}