package di

import com.example.domain.useCases.CreateAuctionUseCase
import dagger.Module
import dagger.Provides
import presentation.viewModels.CreateAuctionViewModelFactory

@Module
class AppModule {
    @Provides
    fun provideCreateAuctionViewModelFactory(createAuctionUseCase: CreateAuctionUseCase)
            : CreateAuctionViewModelFactory {
        return CreateAuctionViewModelFactory(createAuctionUseCase)
    }
}