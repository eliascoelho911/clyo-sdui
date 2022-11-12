package com.clyo.core.android

import android.content.Context
import android.view.View
import com.eliascoelho911.clyo.data.component.ComponentData

typealias ComponentView = View

interface ComponentViewCreator<DATA: ComponentData> {
    fun create(context: Context, data: DATA): ComponentView
}