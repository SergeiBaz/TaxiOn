package di

import com.example.taxion.MainActivity
import dagger.Component

@Component(modules = [ServiceModule::class, RetrofitModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}