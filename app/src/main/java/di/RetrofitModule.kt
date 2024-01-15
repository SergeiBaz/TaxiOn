package di

import com.kts.github.data.network.AuthorizationInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule  {

    private var okhttpClient: OkHttpClient? = null
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        init()
        return Retrofit.Builder()
            .baseUrl("https://staging.lcl:5001")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient!!)
            .build()
    }

    fun init() {
        okhttpClient = OkHttpClient.Builder()
            /*.addNetworkInterceptor(
                HttpLoggingInterceptor {
                    Timber.tag("Network").d(it)
                }
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )*/
            .addNetworkInterceptor(AuthorizationInterceptor())
            /*.addNetworkInterceptor(
                AuthorizationFailedInterceptor(
                    AuthorizationService(context),
                    TokenStorage
                )
            )*/
            .build()
    }
}