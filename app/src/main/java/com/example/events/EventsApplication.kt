package com.example.events

import android.app.Application
import com.example.events.di.eventModule
import com.example.events.di.factoryModule
import com.example.events.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Festus Kiambi on 9/4/19.
 */
class EventsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@EventsApplication)
            // declare modules
            modules(listOf(networkModule, factoryModule, eventModule))
        }

    }
}