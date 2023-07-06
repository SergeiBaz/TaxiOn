package presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Auction
import com.example.domain.useCases.CreateAuctionUseCase
import com.example.domain.useCases.GetArrayAuctionsUseCase
import com.example.domain.useCases.GetAuctionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class AuctionViewModel @Inject constructor(
    private val getAuctionUseCase: GetAuctionUseCase,
    private val getArrayAuctionsUseCase: GetArrayAuctionsUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<Auction?>()
    val uiState: LiveData<Auction?> = _uiState
    private val _idState = MutableLiveData<List<Auction>>()
    val idState: LiveData<List<Auction>> = _idState


    fun getAuction(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("myLog", "Похую мне на вас")
            val auction = getAuctionUseCase(id)
            Log.d("myLog", auction!!.candidates[0].toString())
            withContext(Dispatchers.Main) {
                _uiState.value = auction
            }
        }
    }

    fun getArrayAuctions() {
        viewModelScope.launch {
            val arrayAuctions = getArrayAuctionsUseCase()
            withContext(Dispatchers.Main) {
                _idState.value = arrayAuctions
            }
        }
    }
}
