package com.clyo.core.android

import android.content.Context
import android.view.View
import com.eliascoelho911.clyo.ComponentData

class ViewProvider(
    val componentViewCreators: Set<ComponentViewCreator>
) {
    fun provide(
        context: Context,
        componentData: ComponentData
    ): View {
        return componentViewCreators
            .findCreatorToComponent(componentData.name)
            .validateAndCreate(context, componentData)
    }
}