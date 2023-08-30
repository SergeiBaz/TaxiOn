package presentation.fragments.create_auction_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.taxion.R
import com.example.taxion.databinding.FragmentCreateAuctionBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import dagger.hilt.android.AndroidEntryPoint
import presentation.fragments.create_auction_fragment.YandexMapViewModel.Companion.MAPKIT_API_KEY

@AndroidEntryPoint
class CreateAuctionFragment : Fragment() {
    private lateinit var binding: FragmentCreateAuctionBinding
    private val viewModel by viewModels<CreateAuctionViewModel>()
    private val yandexMapViewModel by viewModels<YandexMapViewModel>()
    lateinit var mapview: MapView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        yandexMapViewModel.setApiKey(savedInstanceState, context)
    }


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

        mapview = binding.mapview
        mapview.map.move(
            CameraPosition(
                Point(56.326802, 44.006506),
                11.0f,
                0.0f,
                0.0f),
            Animation(Animation.Type.SMOOTH, 0f),
            null)

        viewModel.uiState.observe(viewLifecycleOwner) {
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("haveApiKey", true)
    }

    override fun onStart() {
        mapview.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }
    override fun onStop() {
        mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}
