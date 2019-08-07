package com.ajdi.yassin.travelmantics.data

import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.ajdi.yassin.travelmantics.data.model.TravelDeal
import com.ajdi.yassin.travelmantics.utils.*
import com.google.firebase.database.FirebaseDatabase

/**
 * @author Yassin Ajdi
 * @since 8/5/2019.
 */
class TravelDealsRepository : ITravelDealsRepository {
    private val database = FirebaseDatabase.getInstance()
    private val travelDealsRef = database.getReference("/travel_deals")

    override fun getTravelDeals(): LiveData<TravelDealsQueryResults> {
        val liveData = RealtimeDatabaseQueryLiveData(travelDealsRef)
        val deserializeDataSnapshotTransform =
            Function<DataSnapshotOrException, QueryResultsOrException<TravelDeal, Exception>> { input ->
                val (snapshot, exception) = input
                when {
                    snapshot != null -> {
                        val items = snapshot.children.map { child ->
                            val item = TravelDealSnapshotDeserializer().deserialize(child)
                            object : QueryItem<TravelDeal> {
                                override val item: TravelDeal
                                    get() = item
                                override val id: String
                                    get() = child.key!!
                            }
                        }
                        QueryResultsOrException(items, null)
                    }

                    exception != null -> QueryResultsOrException(null, exception)

                    else -> QueryResultsOrException(null, Exception(""))
                }
            }
        return Transformations.map(liveData, deserializeDataSnapshotTransform)
    }
}