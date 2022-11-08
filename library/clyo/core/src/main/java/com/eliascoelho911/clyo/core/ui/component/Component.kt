package com.eliascoelho911.clyo.core.ui.component

import com.eliascoelho911.clyo.core.ui.action.Action

abstract class Component {
    abstract val onClickActions: List<Action>
}