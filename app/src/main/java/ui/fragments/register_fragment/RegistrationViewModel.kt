package ui.fragments.register_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Response
import com.example.domain.entities.UserAuth
import com.example.domain.useCases.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
@ExperimentalCoroutinesApi
class RegistrationViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {
    private val _cropImageView = MutableLiveData("")
    val cropImageView: LiveData<String> = _cropImageView

    private val _progressBarSignUp = MutableLiveData<Boolean>()
    val progressBarSignUp: LiveData<Boolean> = _progressBarSignUp

    private val _signUpSuccess = MutableLiveData<Response<Boolean>>()
    val signUpSuccess: LiveData<Response<Boolean>> = _signUpSuccess

    fun registerUser(userAuth: UserAuth) {
        viewModelScope.launch(Dispatchers.IO) {
            registerUserUseCase.invoke(userAuth).collect() {
                when (it) {
                    is Response.Loading -> _progressBarSignUp.postValue(true)
                    is Response.Fail -> {
                        _progressBarSignUp.postValue(false)
                        _signUpSuccess.postValue(Response.Fail(e = it.e))
                        Log.d("MyLog", "Ошибка регистрации")
                    }
                    is Response.Success -> {
                        val imageUriCache = cropImageView.value.toString()
                    }
                }
            }

        }
    }
}
