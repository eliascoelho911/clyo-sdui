package com.clyo.android.containers

import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.component.componentModule
import com.clyo.component.container
import com.clyo.component.modifications.updateSizeByProperties

val AndroidContainerModule = componentModule {
    container<LinearLayoutCompat>("column") {
        view { LinearLayoutCompat(it) }
        bind { properties ->
            updateSizeByProperties(properties)
            orientation = LinearLayoutCompat.VERTICAL
        }
    }
}