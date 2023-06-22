package di

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() /*{

*//*    lateinit var appComponent: AppComponent*//*

*//*    override fun onCreate() {
        super.onCreate()*//*

    *//*appComponent = DaggerAppComponent
            .builder()
            .serviceModule(ServiceModule(this))
            .build()*//*
    }
}*/