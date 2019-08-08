package com.ajdi.yassin.travelmantics

import android.app.Application
import timber.log.Timber


/**
 * @author Yassin Ajdi
 * @since 8/8/2019.
 */
class TravelDealsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}