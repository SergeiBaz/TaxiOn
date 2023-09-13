package presentation.fragments.yandexMap_fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.taxion.R
import com.example.taxion.databinding.FragmentYandexMapBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.traffic.TrafficColor
import com.yandex.mapkit.traffic.TrafficLevel
import com.yandex.mapkit.traffic.TrafficListener

class YandexMapFragment : Fragment() {
    private lateinit var binding : FragmentYandexMapBinding
    private lateinit var mapKit : MapKit
    private lateinit var mapView : MapView
    private val startLocation = Point(55.804369, 43.168307)
    private var zoomValue: Float = 12.5f
    private val viewModel : YandexMapViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        setApiKey(savedInstanceState, requireContext())
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYandexMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val traffic = MapKitFactory.getInstance().createTrafficLayer(binding.mapView.mapWindow)
        mapView = binding.mapView
        viewModel.startingPoint.observe(viewLifecycleOwner) { point->
            mapView.map.move(
                CameraPosition(
                    startLocation,
                    zoomValue,
                    0.0f,
                    0.0f
                ),
                Animation(Animation.Type.SMOOTH, 0f),
                null
            )
        }
        var click = false
        binding.trafficButton.setOnClickListener {
            if (click) {
                it.setBackgroundResource(R.drawable.ic_traffic)
                }
            else  {
                binding.trafficButton.setBackgroundResource(R.drawable.ic_traffic_green)
                }
            click = !click
            viewModel.trafficCheck(traffic)
            }

       /* val traf = traffic!!.addTrafficListener(object : TrafficListener {
            override fun onTrafficExpired() { }            //   Для показания количества пробок
            override fun onTrafficLoading() { Log.e("My", "subj"); }
            override fun onTrafficChanged(p0: TrafficLevel?) { Log.e("My", p0?.color.toString()); }
        })*/

        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("haveApiKey", true)
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
        MapKitFactory.getInstance().onStart()
        viewModel.setMapStartingPoint(Point(55.804369, 43.168307))
    }

    override fun onStop() {
        super.onStop()
        MapKitFactory.getInstance().onStop()
        binding.mapView.onStop()
    }


    private fun setApiKey(savedInstanceState: Bundle?, context: Context?) {
        val haveApiKey = savedInstanceState?.getBoolean("haveApiKey") ?: false
        if (!haveApiKey) {
            MapKitFactory.setApiKey(MAPKIT_API_KEY)
            MapKitFactory.initialize(context)
        }
    }


    companion object {
        const val MAPKIT_API_KEY = "61f024c0-7f74-48eb-9e73-2149bfd7d951"
    }
}