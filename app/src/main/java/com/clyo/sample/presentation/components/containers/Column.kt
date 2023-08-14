package com.clyo.sample.presentation.components.containers

import android.content.Context
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.android.component.Container

class Column(context: Context) : Container<LinearLayoutCompat>() {
    override val view: LinearLayoutCompat = LinearLayoutCompat(context).apply {
        orientation = LinearLayoutCompat.VERTICAL
    }
}