package di

import android.app.Application
import di.AppComponent
import di.DaggerAppComponent
import di.ServiceModule

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().serviceModule(ServiceModule(this)).build()
    }
}