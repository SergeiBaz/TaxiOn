package com.example.taxion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.service.CreateAuctionUseCase
import com.example.taxion.databinding.ActivityMainBinding
import di.app.App
import kotlinx.coroutines.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var createAuctionUseCase: CreateAuctionUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            createAuctionButton.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    val auction = createAuctionUseCase.execute(
                        editTextStreetFrom.text.toString(),
                        editTextStreetTo.text.toString()
                    )
                    val currentThread = Thread.currentThread().name
                    withContext(Dispatchers.Main) {
                        Log.d("Log", "${auction?.from?.street}")
                        Log.d("Log", "${auction?.to?.street}")
                        Log.d("Log", Thread.currentThread().name)
                        Log.d("Log", currentThread)
                        textViewRendering.text = "${auction?.from?.street}  ${auction?.to?.street}"
                    }
                }

            }
        }
    }
}