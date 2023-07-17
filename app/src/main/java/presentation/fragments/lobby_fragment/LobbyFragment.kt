package presentation.fragments.lobby_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entities.Auction
import com.example.taxion.R
import com.example.taxion.databinding.FragmentLobbyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LobbyFragment : Fragment(), AuctionItemAdapter.Listener {
    private lateinit var binding: FragmentLobbyBinding
    private lateinit var adapter: AuctionItemAdapter
    private val viewModel by viewModels<LobbyViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lobby, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentLobbyBinding.bind(view)
        adapter = AuctionItemAdapter(this)
        viewModel.getArrayAuctions()
        viewModel.idState.observe(viewLifecycleOwner) {
            adapter.setAuctions(it!!)
        }
        val manager = LinearLayoutManager(activity)
        binding.rcViewAuctions.layoutManager = manager
        binding.rcViewAuctions.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(auction: Auction) {
        val controller = findNavController()
        val bundle = Bundle()
        bundle.putInt("id", auction.id)
        controller.navigate(R.id.auctionFragment, bundle)
    }
}