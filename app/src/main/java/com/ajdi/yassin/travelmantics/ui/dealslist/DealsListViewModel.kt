package com.ajdi.yassin.travelmantics.ui.dealslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ajdi.yassin.travelmantics.data.TravelDealsRepository
import com.ajdi.yassin.travelmantics.utils.TravelDealsQueryResults


/**
 * @author Yassin Ajdi
 * @since 8/5/2019.
 */
class DealsListViewModel : ViewModel() {

    private val travelDealsLiveData = TravelDealsRepository().getTravelDeals()

    fun getTravelDeals(): LiveData<TravelDealsQueryResults> {
        return travelDealsLiveData
    }
}