package di

import android.content.Context
import com.example.domain.useCases.CreateAuctionUseCase
import dagger.Module
import dagger.Provides
import com.example.data.repositories.AuctionsRepository
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@InstallIn(ViewModelComponent::class)
@Module
class ServiceModule {
    @Provides
    fun provideCreateAuctionUseCase(repository: AuctionsRepository): CreateAuctionUseCase {
        return CreateAuctionUseCase(repository)
    }

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
}