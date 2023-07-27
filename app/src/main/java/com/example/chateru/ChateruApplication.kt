package com.example.chateru

import android.app.Application
import com.example.chateru.di.appModule
import org.koin.core.context.startKoin

class ChateruApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {

            modules(appModule)
        }
    }

}