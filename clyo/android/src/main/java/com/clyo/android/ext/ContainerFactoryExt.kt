package com.clyo.android.ext

import android.content.Context
import com.clyo.android.ClyoApplication
import com.clyo.android.ui.Container
import com.clyo.data.container.ContainerJson

internal fun container(
    context: Context,
    type: ContainerJson,
): Container<*> {
    return ClyoApplication.tools().createContainer(context, type)
}