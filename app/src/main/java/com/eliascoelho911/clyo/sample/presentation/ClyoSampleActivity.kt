package com.eliascoelho911.clyo.sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eliascoelho911.clyo.android.androidClyoEngine
import com.eliascoelho911.clyo.android.startAndroidClyo
import com.eliascoelho911.clyo.sample.R
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ClyoSampleActivity : AppCompatActivity(R.layout.activity_clyo_sample) {
    private val viewModel: ClyoSampleViewModel by viewModel()
    private val clyoEngine by androidClyoEngine()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startAndroidClyo(rootId = R.id.root)

        viewModel.screenContent.observe(this) {
            clyoEngine.submitScreen(it)
        }
    }
}