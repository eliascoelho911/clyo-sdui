package com.clyo.android.component.container

import android.view.ViewGroup
import com.clyo.android.component.ComponentBinder
import com.clyo.android.properties.AbstractPropertiesData

class ContainerBinder<T : ViewGroup>(
    override val binderBlock: T.(properties: AbstractPropertiesData) -> Unit
) : ComponentBinder<T>()