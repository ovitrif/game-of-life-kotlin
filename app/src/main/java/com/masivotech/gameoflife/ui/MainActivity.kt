package com.masivotech.gameoflife.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProvider
import com.masivotech.gameoflife.App
import com.masivotech.gameoflife.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        App.INSTANCE.container.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.startButton.setOnClickListener {
            viewModel.onStartGameClick()
        }

        initObservers()
    }

    private fun initObservers() {
        viewModel.gameOutput.observe(this, { output ->
            binding.outputView.text = output
        })

        viewModel.gameStarted.observe(this, { isGameStarted ->
            binding.startButton.isGone = isGameStarted
        })
    }
}
