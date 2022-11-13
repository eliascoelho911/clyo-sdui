package com.eliascoelho911.clyo.android.components

import android.widget.Button
import com.clyo.core.android.annotations.ComponentViewCreator
import com.eliascoelho911.clyo.annotations.DeclareProperty

@ComponentViewCreator("android.button", Button::class)
@DeclareProperty("text", String::class)
internal interface ButtonViewCreator