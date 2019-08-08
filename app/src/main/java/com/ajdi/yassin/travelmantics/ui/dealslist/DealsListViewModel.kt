package com.ajdi.yassin.travelmantics.ui.dealslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajdi.yassin.travelmantics.data.TravelDealsRepository
import com.ajdi.yassin.travelmantics.data.model.TravelDeal
import com.ajdi.yassin.travelmantics.utils.Event
import com.ajdi.yassin.travelmantics.utils.TravelDealsQueryResults


/**
 * @author Yassin Ajdi
 * @since 8/5/2019.
 */
class DealsListViewModel : ViewModel() {

//    private val travelDealsLiveData = TravelDealsRepository().getTravelDeals()

    private val _openDealEvent = MutableLiveData<Event<String>>()
    lateinit var selectedDeal: TravelDeal

    fun getTravelDeals(): LiveData<TravelDealsQueryResults> {
        return TravelDealsRepository().getTravelDeals()
    }

    fun openDealEvent(deal: TravelDeal) {
        selectedDeal = deal
        _openDealEvent.value = Event(deal.id)
    }

    fun getOpenDealEvent(): LiveData<Event<String>> {
        return _openDealEvent
    }
}