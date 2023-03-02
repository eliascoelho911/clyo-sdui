package com.eliascoelho911.clyo.sample.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clyo.android.ClyoContext
import com.clyo.android.clyo
import com.eliascoelho911.clyo.sample.R
import com.eliascoelho911.clyo.sample.databinding.ActivityClyoSampleBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

//Todo Fazer teste de Leak
internal class ClyoSampleActivity :
    AppCompatActivity(R.layout.activity_clyo_sample), ClyoContext {

    private val viewModel: ClyoSampleViewModel by viewModel()

    private val binding: ActivityClyoSampleBinding by lazy {
        val root = findViewById<View>(R.id.clyoContainerView)
        ActivityClyoSampleBinding.bind(root)
    }

    private val clyo by clyo(ClyoComponents)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.screenContent.observe(this) {
            clyo.render(it, binding.clyoContainerView)
        }
    }
}