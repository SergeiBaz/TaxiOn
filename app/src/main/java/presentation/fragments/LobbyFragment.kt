package presentation.fragments

import adapter.AuctionItemAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taxion.R
import com.example.taxion.databinding.FragmentLobbyBinding
import dagger.hilt.android.AndroidEntryPoint
import presentation.viewModels.AuctionViewModel

@AndroidEntryPoint
class LobbyFragment : Fragment() {
    private lateinit var binding: FragmentLobbyBinding
    private lateinit var adapter: AuctionItemAdapter
    private val viewModel by viewModels<AuctionViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lobby, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentLobbyBinding.bind(view)
        adapter = AuctionItemAdapter()
        viewModel.idState.observe(this@LobbyFragment) {
            adapter.setAuctions(it)
        }
        viewModel.getArrayAuctions()
        val manager = LinearLayoutManager(activity)
        binding.rcViewAuctions.layoutManager = manager
        binding.rcViewAuctions.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }
}