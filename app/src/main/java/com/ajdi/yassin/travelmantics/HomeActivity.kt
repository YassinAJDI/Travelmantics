package com.ajdi.yassin.travelmantics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Timber.d("onCreate")
    }
}
