package com.clyo.android.widgets.material3

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.clyo.android.component.widget.binders.applyTextViewProperties
import com.clyo.android.component.widget.binders.applyViewProperties
import com.clyo.android.dsl.clyoComponents

val ClyoWidgetsModule = clyoComponents {
    widget<AppCompatImageView>("image") {
        binder { properties ->
            applyViewProperties(properties)
        }
    }

    widget<AppCompatTextView>("text") {
        binder { properties ->
            applyTextViewProperties(properties)
        }
    }
}