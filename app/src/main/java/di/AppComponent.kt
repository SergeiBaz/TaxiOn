package di

import presentation.MainActivity
import dagger.Component

@Component(modules = [ServiceModule::class, RetrofitModule::class, AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}