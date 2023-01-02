package com.eliascoelho911.clyo.sample.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clyo.android.findClyoAndroid
import com.eliascoelho911.clyo.sample.R
import com.eliascoelho911.clyo.sample.databinding.ActivityClyoSampleBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ClyoSampleActivity :
    AppCompatActivity(R.layout.activity_clyo_sample) {

    private val viewModel: ClyoSampleViewModel by viewModel()

    private val binding: ActivityClyoSampleBinding by lazy {
        val root = findViewById<View>(R.layout.activity_clyo_sample)
        ActivityClyoSampleBinding.bind(root)
    }

    //Todo Criar uma alternativa para não precisar inicializar o clyo assim, sendo algo mais automático
    private val clyo by findClyoAndroid()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.clyoContainerView.clyo = clyo

        viewModel.screenContent.observe(this) {
            binding.clyoContainerView.render(it)
        }
    }
}