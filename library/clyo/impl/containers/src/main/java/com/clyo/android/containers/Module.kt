package com.clyo.android.containers

import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.core.component.componentModule
import com.clyo.core.component.container.addContent
import com.clyo.core.component.provider.container

val AndroidContainerModule = componentModule {
    container("column") { context, data ->
        LinearLayoutCompat(context).apply {
            orientation = LinearLayoutCompat.VERTICAL
            addContent(data.content)
        }
    }
}