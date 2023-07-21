package ui.fragments.auction_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxion.databinding.FragmentAuctionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuctionFragment : Fragment() {
    private lateinit var binding: FragmentAuctionBinding
    private lateinit var adapter: DriverItemAdapter
    private val viewModel by viewModels<AuctionViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuctionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = DriverItemAdapter()
        viewModel.getAuction(requireArguments())

        viewModel.idState.observe(viewLifecycleOwner) {
            adapter.setDrivers(it.candidateIdCollection)
        }
        val manager = LinearLayoutManager(activity)
        binding.driverRcView.layoutManager = manager
        binding.driverRcView.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }
}