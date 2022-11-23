package com.clyo.core.android

import android.content.Context
import android.view.View
import com.eliascoelho911.clyo.ComponentData

class ViewProvider {
    fun provide(
        context: Context,
        data: ComponentData
    ): View {
        return ComponentFactoryModule.findAndInstantiateByData(data).create(context, data)
    }
}