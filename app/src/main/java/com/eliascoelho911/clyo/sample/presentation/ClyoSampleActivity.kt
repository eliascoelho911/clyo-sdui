package com.eliascoelho911.clyo.sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clyo.component.ClyoComponent
import com.eliascoelho911.clyo.sample.R
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ClyoSampleActivity :
    AppCompatActivity(R.layout.activity_clyo_sample), ClyoComponent {

    private val viewModel: ClyoSampleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.screenContent.observe(this) {
            clyoEngine.showScreen(it, findViewById(R.id.root))
        }
    }
}