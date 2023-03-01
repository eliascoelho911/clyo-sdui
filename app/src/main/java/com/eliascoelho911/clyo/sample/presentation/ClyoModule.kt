package com.eliascoelho911.clyo.sample.presentation

import com.clyo.android.component.dsl.clyoModule
import com.clyo.android.widgets.material3.ClyoMaterial3Module

internal val ClyoSampleModule = clyoModule {
    add(ClyoMaterial3Module)
}