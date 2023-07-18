package com.clyo.android.scope

import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import kotlin.properties.ReadOnlyProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class Clyo internal constructor(private val rootView: ViewGroup)