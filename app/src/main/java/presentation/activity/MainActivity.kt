package presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.domain.useCases.CreateAuctionUseCase
import com.example.taxion.databinding.ActivityMainBinding
import di.App
import presentation.viewModels.CreateAuctionViewModel
import presentation.viewModels.CreateAuctionViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CreateAuctionViewModel

    @Inject
    lateinit var viewModelFactory: CreateAuctionViewModelFactory

    @Inject
    lateinit var createAuctionUseCase: CreateAuctionUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, viewModelFactory)[CreateAuctionViewModel::class.java]
        viewModel.uiState.observe(this) {
            binding.textViewRendering.text = it
        }
        binding.apply {
            createAuctionButton.setOnClickListener {
                viewModel.createAuction(
                    editTextStreetFrom.text.toString(),
                    editTextStreetTo.text.toString()
                )
            }
        }
    }
}