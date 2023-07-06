package di

import android.content.Context
import com.example.domain.useCases.CreateAuctionUseCase
import dagger.Module
import dagger.Provides
import com.example.data.repositories.AuctionsRepository
import com.example.domain.useCases.GetArrayAuctionsUseCase
import com.example.domain.useCases.GetAuctionUseCase
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class ServiceModule {
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