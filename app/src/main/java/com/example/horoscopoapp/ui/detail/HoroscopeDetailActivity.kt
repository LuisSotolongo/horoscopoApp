package com.example.horoscopoapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscopoapp.R
import com.example.horoscopoapp.databinding.ActivityHoroscopeDetailBinding
import com.example.horoscopoapp.domain.model.HoroscopeModel
import com.example.horoscopoapp.domain.model.HoroscopeModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()
    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniUi()
        horoscopeDetailViewModel.getHoroscope(args.type)
    }

    private fun iniUi() {
        initListener()
        iniUiState()
    }

    private fun initListener() {
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun iniUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                        HoroscopeDetailState.loading -> loadingState()
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.pbProgress.isVisible = true
    }

    private fun errorState() {
        binding.pbProgress.isVisible = false
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pbProgress.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction
        val image = when(state.horoscopeModel){
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Escorpio -> R.drawable.detail_scorpio
            Sagitario -> R.drawable.detail_sagittarius
            Capricornio -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Piscis -> R.drawable.detail_pisces
        }
        binding.ivDetail.setImageResource(image)
    }
}