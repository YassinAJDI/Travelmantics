package com.ajdi.yassin.travelmantics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.ajdi.yassin.travelmantics.ui.dealslist.DealsListViewModel
import timber.log.Timber

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Timber.d("onCreate")
    }

    companion object {
        fun obtainViewModel(activity: FragmentActivity?): DealsListViewModel {
            return ViewModelProviders.of(activity!!).get(DealsListViewModel::class.java)
        }
    }

}
