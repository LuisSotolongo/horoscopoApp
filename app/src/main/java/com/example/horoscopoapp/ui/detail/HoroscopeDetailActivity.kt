package com.example.horoscopoapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscopoapp.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel : HoroscopeDetailViewModel by viewModels()
    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniUi()
        horoscopeDetailViewModel.getHoroscope(args.type.name)
    }

    private fun iniUi() {
        iniUiState()
    }

    private fun iniUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeDetailViewModel.state.collect{
                    when(it){
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                        HoroscopeDetailState.loading ->  loadingState()
                    }
                }
            }
        }
    }

    private fun loadingState() {
      binding.pbProgress.isVisible = true
    }

    private fun errorState(){
        binding.pbProgress.isVisible = false
    }
    private fun successState(state: HoroscopeDetailState.Success){
        binding.pbProgress.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction
    }
}