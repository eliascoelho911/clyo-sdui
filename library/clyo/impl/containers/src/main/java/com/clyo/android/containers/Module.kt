package com.clyo.android.containers

import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.ui.dsl.viewBinders

val ContainersBinders = viewBinders {
    binder<LinearLayoutCompat>("column") { properties ->
        orientation = LinearLayoutCompat.VERTICAL
    }
}