package com.eliascoelho911.clyo.sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clyo.core.android.ComponentFactoryModule
import com.clyo.core.android.startAndroidClyo
import com.eliascoelho911.clyo.android.components.AndroidComponentViewFactories
import com.eliascoelho911.clyo.clyoEngine
import com.eliascoelho911.clyo.sample.R
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ClyoSampleActivity : AppCompatActivity(R.layout.activity_clyo_sample) {
    private val viewModel: ClyoSampleViewModel by viewModel()
    private val clyoEngine by clyoEngine()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComponentFactoryModule.set(AndroidComponentViewFactories)
        startAndroidClyo(rootId = R.id.root)

        viewModel.screenContent.observe(this) {
            clyoEngine.submitScreen(it)
        }
    }
}