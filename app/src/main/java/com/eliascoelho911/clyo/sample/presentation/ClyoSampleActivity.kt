package com.eliascoelho911.clyo.sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clyo.core.getClyoEngine
import com.eliascoelho911.clyo.sample.R
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ClyoSampleActivity : AppCompatActivity(R.layout.activity_clyo_sample) {
    private val viewModel: ClyoSampleViewModel by viewModel()

    private val clyoEngine by getClyoEngine()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
 
        viewModel.screenContent.observe(this) {
            clyoEngine.showScreen(it, findViewById(R.id.root))
        }
    }
}