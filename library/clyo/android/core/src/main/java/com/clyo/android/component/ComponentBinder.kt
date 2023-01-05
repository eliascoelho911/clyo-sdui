package com.clyo.android.component

import android.view.View
import com.clyo.android.properties.PropertiesAssignor

internal interface ComponentBinder<T : View> : PropertiesAssignor<T>