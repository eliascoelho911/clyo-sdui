package com.clyo.core.android

import android.content.Context
import android.view.View
import com.eliascoelho911.clyo.data.component.ComponentData
import kotlin.reflect.KClass

class ViewProvider(
    val componentViewCreators: Map<KClass<out ComponentData>, ComponentViewCreator<*>>
) {

    @Suppress("UNCHECKED_CAST")
    inline fun <reified DATA : ComponentData> provide(
        context: Context,
        componentData: DATA
    ): View {
        val creator = componentViewCreators[DATA::class] as ComponentViewCreator<DATA>? ?: error("")
        return creator.create(context, componentData)
    }
}