package com.eliascoelho911.clyo.sample.presentation

import com.clyo.android.containers.ContainersModule
import com.clyo.android.dsl.clyoComponents
import com.clyo.android.widgets.material3.ClyoWidgetsModule

internal val ClyoComponents = clyoComponents {
    add(ClyoWidgetsModule)
    add(ContainersModule)
}