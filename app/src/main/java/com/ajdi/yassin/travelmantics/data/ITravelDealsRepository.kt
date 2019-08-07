package com.ajdi.yassin.travelmantics.data

import androidx.lifecycle.LiveData
import com.ajdi.yassin.travelmantics.data.model.DataOrException
import com.ajdi.yassin.travelmantics.data.model.TravelDeal
import com.ajdi.yassin.travelmantics.utils.TravelDealsQueryResults

/**
 * @author Yassin Ajdi
 * @since 8/5/2019.
 */
interface ITravelDealsRepository {

    fun getTravelDeals() : LiveData<TravelDealsQueryResults>
}