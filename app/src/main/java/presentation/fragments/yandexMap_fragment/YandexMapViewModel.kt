package presentation.fragments.yandexMap_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.traffic.TrafficLayer

class YandexMapViewModel : ViewModel() {
    private var isTrafficActive = false
    private val _startingPoint = MutableLiveData<Point>()
    val startingPoint: LiveData<Point> = _startingPoint

    fun setMapStartingPoint (point: Point) {
        _startingPoint.value = point
    }

    fun trafficCheck(trafficLayer: TrafficLayer) {
        trafficLayer.isTrafficVisible = !isTrafficActive
        isTrafficActive = !isTrafficActive
    }
}