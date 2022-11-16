package com.clyo.core.android

import android.content.Context
import android.view.View
import com.eliascoelho911.clyo.ComponentData

// Todo permitir que os factories tenham argumentos no construtor.
// Todo permitir adicionar custom factories
class ViewProvider {
    fun provide(
        context: Context,
        data: ComponentData
    ): View {
        // Todo adicionar tratativa para o envio de varios factories para o mesmo componente
        return ComponentFactoryModule.findAndInstantiateByData(data).create(context, data)
    }
}