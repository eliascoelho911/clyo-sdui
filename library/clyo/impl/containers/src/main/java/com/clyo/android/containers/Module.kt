package com.clyo.android.containers

import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.android.view.viewBinders

val ContainersBinders = viewBinders {
    binder<LinearLayoutCompat>("column") { properties ->
        orientation = LinearLayoutCompat.VERTICAL
    }
}