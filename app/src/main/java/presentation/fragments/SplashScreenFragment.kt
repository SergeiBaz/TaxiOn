package presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.taxion.databinding.FragmentSplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import presentation.viewModels.CreateAuctionViewModel

@AndroidEntryPoint
class SplashScreenFragment : Fragment() {
    private lateinit var binding: FragmentSplashScreenBinding
    private val viewModel by viewModels<CreateAuctionViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding
            .inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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