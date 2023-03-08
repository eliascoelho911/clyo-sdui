package com.eliascoelho911.clyo.sample.presentation

import com.clyo.android.containers.ContainersModule
import com.clyo.android.dsl.clyoDeclarations
import com.clyo.android.widgets.material3.ClyoWidgetsModule

internal val ClyoComponents = clyoDeclarations {
    add(ClyoWidgetsModule)
    add(ContainersModule)
}