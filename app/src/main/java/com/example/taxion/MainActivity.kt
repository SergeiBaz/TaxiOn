package com.example.taxion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.service.CreateAuctionUseCase
import com.example.taxion.databinding.ActivityMainBinding
import di.app.App
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
            run {  createAuctionUseCase.execute(
                    editTextStreetFrom.text.toString(),
                editTextStreetTo.text.toString())
            }
        }
        }
    }
}