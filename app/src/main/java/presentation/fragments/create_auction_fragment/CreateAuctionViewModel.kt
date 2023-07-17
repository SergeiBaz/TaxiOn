package presentation.fragments.create_auction_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.useCases.CreateAuctionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class CreateAuctionViewModel @Inject constructor
    (
    private val createAuctionUseCase: CreateAuctionUseCase
    ) : ViewModel() {
    private val _uiState = MutableLiveData<String>()
    val uiState: LiveData<String> = _uiState

    fun createAuction(from: String, to: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val auction = createAuctionUseCase(from, to)
            withContext(Dispatchers.Main) {
                _uiState.value = auction?.to?.street
                Log.d("Log", "${auction?.from?.street}")
                Log.d("Log", "${auction?.to?.street}")
            }
        }
    }
}