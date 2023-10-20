package presentation.fragments.passenger_auction_fragment

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Auction
import com.example.domain.useCases.GetAuctionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import presentation.Constants.Constants
import javax.inject.Inject

@HiltViewModel
class PassengerAuctionViewModel @Inject constructor
    (
    private val getAuctionUseCase: GetAuctionUseCase
) : ViewModel() {
    private val _currentGetAuctionState = MutableLiveData<Auction>()
    val currentGetAuctionState: LiveData<Auction> = _currentGetAuctionState

    fun getInfoAuction(bundle: Bundle) {
        viewModelScope.launch {
            val auction = getAuctionUseCase(
                bundle.getInt(Constants.KEY_ID_AUCTION)
            )
        }
    }
}