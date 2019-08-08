package com.ajdi.yassin.travelmantics.data

import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.ajdi.yassin.travelmantics.data.model.TravelDeal
import com.ajdi.yassin.travelmantics.utils.*
import com.google.firebase.database.FirebaseDatabase
import timber.log.Timber

/**
 * @author Yassin Ajdi
 * @since 8/5/2019.
 */
class TravelDealsRepository : ITravelDealsRepository {
    private val database = FirebaseDatabase.getInstance()
    private val travelDealsRef = database.getReference("/travel_deals")

    override fun getTravelDeals(): LiveData<TravelDealsQueryResults> {
        Timber.d("getTravelDeals")
        val liveData = RealtimeDatabaseQueryLiveData(travelDealsRef)
        val deserializeDataSnapshotTransform =
            Function<DataSnapshotOrException, QueryResultsOrException<TravelDeal, Exception>> { input ->
                val (snapshot, exception) = input
                when {
                    snapshot != null -> try {
                        val items: List<QueryItem<TravelDeal>> = snapshot.children.map { child ->
                            val item = TravelDealSnapshotDeserializer().deserialize(child)
                            Timber.d(item.toString())
                            object : QueryItem<TravelDeal> {
                                override val item: TravelDeal
                                    get() = item
                                override val id: String
                                    get() = child.key!!
                            }
                        }
                        Timber.d("items count: ${items.size}")
                        QueryResultsOrException(items, null)
                    } catch (error: RuntimeException) {
                        QueryResultsOrException<TravelDeal, Exception>(null, error)
                    }

                    exception != null -> QueryResultsOrException(null, exception)

                    else -> QueryResultsOrException(null, Exception(""))
                }
            }
        return Transformations.map(liveData, deserializeDataSnapshotTransform)
    }
}