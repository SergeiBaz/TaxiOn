package di

import android.content.Context
import com.example.domain.useCases.CreateAuctionUseCase
import dagger.Module
import dagger.Provides
import com.example.data.repositories.AuctionsRepository
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
@ExperimentalCoroutinesApi
class ServiceModule {
    @Provides
    @Singleton
    fun providesUserRepository(userAuthStorage: UserAuthStorage): UserRepository {
        return UserRepository(userAuthStorage = userAuthStorage)
    }
    @Provides
    @Singleton
    fun providesUserAuthStorage(): UserAuthStorage {
        return FirebaseUserAuthStorage()
    }

    @Provides
    fun provideRegisterUserUseCase(repository: UserRepository): RegisterUserUseCase {
        return RegisterUserUseCase(repository)
    }
    @Provides
    fun provideCreateAuctionUseCase(repository: AuctionsRepository): CreateAuctionUseCase {
        return CreateAuctionUseCase(repository)
    }

    @Provides
    fun provideGetAuctionUseCase(repository: AuctionsRepository): GetAuctionUseCase {
        return GetAuctionUseCase(repository)
    }

    @Provides
    fun provideGetArrayAuctionUseCase(repository: AuctionsRepository): GetArrayAuctionsUseCase {
        return GetArrayAuctionsUseCase(repository)
    }

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
}