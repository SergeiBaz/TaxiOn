package presentation.fragments.create_auction_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.taxion.databinding.FragmentCreateAuctionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateAuctionFragment : Fragment() {
    private lateinit var binding: FragmentCreateAuctionBinding
    private val viewModel by viewModels<CreateAuctionViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateAuctionBinding
            .inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.currentAuctionState.observe(viewLifecycleOwner) {
            binding.textViewRendering.text = it.to.street
        }
        binding.apply {
            createAuctionButton.setOnClickListener {
                viewModel.createAuction(
                    streetFrom.text.toString(),
                    streetTo.text.toString(),

                )

            }
        }
    }
}