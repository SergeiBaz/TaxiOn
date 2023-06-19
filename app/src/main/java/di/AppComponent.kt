package di

import presentation.activity.MainActivity
import dagger.Component

@Component(modules = [ServiceModule::class, RetrofitModule::class, AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}