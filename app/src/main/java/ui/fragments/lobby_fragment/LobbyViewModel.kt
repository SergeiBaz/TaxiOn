package ui.fragments.lobby_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Auction
import com.example.domain.useCases.GetArrayAuctionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class LobbyViewModel @Inject constructor(
    private val getArrayAuctionsUseCase: GetArrayAuctionsUseCase
) : ViewModel() {
    private val _idState = MutableLiveData<List<Auction>?>()
    val idState: LiveData<List<Auction>?> = _idState

    fun getArrayAuctions() {
        viewModelScope.launch {
            val arrayAuctions = getArrayAuctionsUseCase()
            withContext(Dispatchers.Main) {
                _idState.value = arrayAuctions
            }
        }
    }
}
