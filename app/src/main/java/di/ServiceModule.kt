package di

import android.content.Context
import com.example.domain.useCases.CreateAuctionUseCase
import dagger.Module
import dagger.Provides
import com.example.data.repositories.AuctionsRepository


@Module
class ServiceModule(val context: Context) {
    @Provides
    fun provideCreateAuctionUseCase(repository: AuctionsRepository): CreateAuctionUseCase {
        return CreateAuctionUseCase(repository)
    }

    @Provides
    fun provideContext(): Context {
        return context
    }

}