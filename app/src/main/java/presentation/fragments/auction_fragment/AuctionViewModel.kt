package presentation.fragments.auction_fragment

import android.os.Bundle
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
import presentation.Constants.Constants
import javax.inject.Inject

@HiltViewModel
class AuctionViewModel @Inject constructor(
    private val getAuctionUseCase: GetAuctionUseCase
) : ViewModel() {
    private val _idState = MutableLiveData<Auction>()
    val idState: LiveData<Auction> = _idState

    fun getAuction(bundle: Bundle) {
        viewModelScope.launch {
            val auction = getAuctionUseCase(
                bundle.getInt(Constants.KEY_ID_AUCTION)
            )
            withContext(Dispatchers.Main) {
                _idState.value = auction!!
            }
        }
    }
}