package di

import android.content.Context
import com.example.service.CreateAuctionUseCase
import dagger.Module
import dagger.Provides
import data.repositories.AuctionsRepository


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