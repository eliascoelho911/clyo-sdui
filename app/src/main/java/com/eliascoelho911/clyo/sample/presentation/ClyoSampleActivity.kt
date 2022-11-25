package com.eliascoelho911.clyo.sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clyo.android.containers.AndroidContainerRendererModule
import com.clyo.android.material.components.Material3WidgetRendererModule
import com.clyo.core.component.renderer.ComponentRendererProvider
import com.clyo.core.getClyoEngine
import com.clyo.core.startClyo
import com.eliascoelho911.clyo.sample.R
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ClyoSampleActivity : AppCompatActivity(R.layout.activity_clyo_sample) {
    private val viewModel: ClyoSampleViewModel by viewModel()

    private val clyoEngine by getClyoEngine()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startClyo(
            ComponentRendererProvider(
                widgetRendererModule = Material3WidgetRendererModule,
                containerRendererModule = AndroidContainerRendererModule
            )
        )

        viewModel.screenContent.observe(this) {
            clyoEngine.showScreen(it, findViewById(R.id.root))
        }
    }
}