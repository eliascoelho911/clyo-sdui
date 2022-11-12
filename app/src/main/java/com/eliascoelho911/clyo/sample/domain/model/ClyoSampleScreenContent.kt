package com.eliascoelho911.clyo.sample.domain.model

import com.eliascoelho911.clyo.data.ScreenData
import com.eliascoelho911.clyo.data.component.ComponentData

data class ClyoSampleScreenContent(
    override val content: ComponentData
): ScreenData