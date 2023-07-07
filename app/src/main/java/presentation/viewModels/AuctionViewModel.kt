package presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Auction
import com.example.domain.useCases.GetAuctionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuctionViewModel @Inject constructor(
    private val getAuctionUseCase: GetAuctionUseCase
) : ViewModel() {
    private val _idState = MutableLiveData<Auction>()
    val idState: LiveData<Auction> = _idState

    fun getAuction() {
        viewModelScope.launch {
            val auction = getAuctionUseCase(2)
            withContext(Dispatchers.Main) {
                _idState.value = auction!!
            }
        }
    }
}