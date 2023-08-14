package com.clyo.android.scope.provider

import android.content.Context
import com.clyo.android.scope.ClyoScope

internal fun createClyo(context: Context): ClyoScope = ClyoScope(context)