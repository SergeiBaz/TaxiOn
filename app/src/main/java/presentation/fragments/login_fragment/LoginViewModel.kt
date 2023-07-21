package presentation.fragments.login_fragment

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import net.openid.appauth.AuthorizationException
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationService
import net.openid.appauth.AuthorizationServiceConfiguration
import net.openid.appauth.ResponseTypeValues
import net.openid.appauth.TokenRequest

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val authService: AuthorizationService = AuthorizationService(getApplication())
    private val openAuthPageEventChannel = Channel<Intent>(Channel.BUFFERED)
    private val toastEventChannel = Channel<Int>(Channel.BUFFERED)
    private val authSuccessEventChannel = Channel<Unit>(Channel.BUFFERED)
    private val loadingMutableStateFlow = MutableStateFlow(false)
    private val serviceConfiguration = AuthorizationServiceConfiguration(
        Uri.parse(AuthConfig.AUTH_URI),
        Uri.parse(AuthConfig.TOKEN_URI),
        null, // registration endpoint
        Uri.parse(AuthConfig.END_SESSION_URI)
    )
    val openAuthPageFlow: Flow<Intent>
        get() = openAuthPageEventChannel.receiveAsFlow()
    val loadingFlow: Flow<Boolean>
        get() = loadingMutableStateFlow.asStateFlow()
    val toastFlow: Flow<Int>
        get() = toastEventChannel.receiveAsFlow()

    val authSuccessFlow: Flow<Unit>
        get() = authSuccessEventChannel.receiveAsFlow()


    fun getAuthRequest(): AuthorizationRequest {
        val redirectUri = AuthConfig.CALLBACK_URL.toUri()
        return AuthorizationRequest.Builder(
            serviceConfiguration,
            AuthConfig.CLIENT_ID,
            AuthConfig.RESPONSE_TYPE,
            redirectUri
        )
            .setScope(AuthConfig.SCOPE)
            .build()
    }

    fun onAuthCodeFailed(exception: AuthorizationException) {
        Log.d("mylog", exception.message.toString())
    }

    fun onAuthCodeReceived(tokenRequest: TokenRequest) {
        Log.d("mylog", tokenRequest.authorizationCode.toString())
    }


    fun openLoginPage() {
        val customTabsIntent = CustomTabsIntent.Builder().build()

        val authRequest = getAuthRequest()

        Log.d(
            "mylog",
            "1. Generated verifier=${authRequest.codeVerifier},challenge=${authRequest.codeVerifierChallenge}"
        )

        val openAuthPageIntent = authService.getAuthorizationRequestIntent(
            authRequest,
            customTabsIntent
        )
        openAuthPageEventChannel.trySendBlocking(openAuthPageIntent)
        /*     Timber.tag("Oauth").d("2. Open auth page: ${authRequest.toUri()}")*/
    }


    override fun onCleared() {
        super.onCleared()
        authService.dispose()
    }
}

/*object AuthConfig {
    const val AUTH_URI = "https://github.com/login/oauth/authorize"
    const val TOKEN_URI = "https://github.com/login/oauth/access_token"
    const val END_SESSION_URI = "https://github.com/logout"
    const val RESPONSE_TYPE = ResponseTypeValues.CODE
    const val SCOPE = "user,repo"
    const val CLIENT_ID = "4e6c891d3f1c4618e693"
    const val CLIENT_SECRET = "9db6630f1132b30cdf0fe3fafd7e4e166fcff98d"
    const val CALLBACK_URL = "ru.taxion.oauth://github.com/callback"
    const val LOGOUT_CALLBACK_URL = "ru.taxion.oauth://github.com/logout_callback"
}*/

object AuthConfig {
    const val AUTH_URI = "https://staging.lcl:7076/connect/authorize"
    const val TOKEN_URI = "https://staging.lcl:7076/connect/token"
    const val END_SESSION_URI = "https://staging.lcl:7076/connect/endsession"
    const val RESPONSE_TYPE = ResponseTypeValues.CODE
    const val SCOPE = "LetsJourneyWebApi,openid"
    const val CLIENT_ID = "Mobile"
    const val CLIENT_SECRET = "9db6630f1132b30cdf0fe3fafd7e4e166fcff98d"
    const val CALLBACK_URL = "ru.taxion.oauth://github.com/callback"
    const val LOGOUT_CALLBACK_URL = "ru.taxion.oauth://github.com/logout_callback"
}