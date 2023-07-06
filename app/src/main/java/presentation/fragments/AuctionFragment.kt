package presentation.fragments

import adapter.AuctionItemAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.taxion.databinding.FragmentAuctionBinding
import dagger.hilt.android.AndroidEntryPoint
import presentation.viewModels.AuctionViewModel

@AndroidEntryPoint
class AuctionFragment : Fragment() {
    private lateinit var binding: FragmentAuctionBinding
    private lateinit var adapter: AuctionItemAdapter
    private val viewModel by viewModels<AuctionViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuctionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }
}