package com.clyo.android.containers

import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.core.component.renderer.containerRenderer
import com.clyo.core.component.renderer.containerRendererModule

val AndroidContainerRendererModule = containerRendererModule {
    containerRenderer<LinearLayoutCompat>("column") {
        orientation = LinearLayoutCompat.VERTICAL
    }
}