package presentation.fragments.create_auction_fragment

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.yandex.mapkit.MapKitFactory


class YandexMapViewModel: ViewModel() {

    fun setApiKey(savedInstanceState: Bundle?, context: Context?) {
        val haveApiKey = savedInstanceState?.getBoolean("haveApiKey") ?: false // При первом запуске приложения всегда false
        if (!haveApiKey) {
            MapKitFactory.setApiKey(MAPKIT_API_KEY)
            MapKitFactory.initialize(context)
        }
    }



    companion object {
        const val MAPKIT_API_KEY = "61f024c0-7f74-48eb-9e73-2149bfd7d951"
    }
}

