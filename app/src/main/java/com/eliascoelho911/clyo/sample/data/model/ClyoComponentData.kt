package com.eliascoelho911.clyo.sample.data.model

import com.eliascoelho911.clyo.ComponentData
import com.eliascoelho911.clyo.ComponentName
import com.eliascoelho911.clyo.ComponentProperties

internal data class ClyoComponentData(
    override val name: ComponentName,
    override val properties: ComponentProperties
) : ComponentData