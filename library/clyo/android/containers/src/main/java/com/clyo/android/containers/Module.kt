package com.clyo.android.containers

import com.clyo.android.dsl.clyoComponents

val ContainersBinders = clyoComponents {
    contain
    binder<LinearLayoutCompat>("column") { properties ->
        orientation = LinearLayoutCompat.VERTICAL
    }
}