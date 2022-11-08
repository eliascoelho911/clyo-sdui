package com.eliascoelho911.notate.clyo.core.ui.component

import com.eliascoelho911.notate.clyo.core.ui.action.Action

abstract class Component {
    abstract val onClickActions: List<Action>
}