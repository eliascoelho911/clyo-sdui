package com.clyo.android.containers

import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.core.component.componentModule
import com.clyo.core.component.container
import com.clyo.core.component.modifications.updateSizeByProperties

val AndroidContainerModule = componentModule {
    container<LinearLayoutCompat>("column") {
        view { LinearLayoutCompat(it) }
        bind { properties ->
            updateSizeByProperties(properties)
            orientation = LinearLayoutCompat.VERTICAL
        }
    }
}