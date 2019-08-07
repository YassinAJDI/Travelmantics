package com.ajdi.yassin.travelmantics.utils

import com.ajdi.yassin.travelmantics.data.model.DataOrException
import com.ajdi.yassin.travelmantics.data.model.TravelDeal
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseException

/**
 * @author Yassin Ajdi
 * @since 8/7/2019.
 */


/**
 * An item of data type T that resulted from a query. It adds the notion of
 * a unique id to that item.
 */
interface QueryItem<T> {
    val item: T
    val id: String
}

typealias DataSnapshotOrException = DataOrException<DataSnapshot?, DatabaseException?>

/**
 * The results of a database query (a List of QueryItems), or an Exception.
 */
typealias QueryResultsOrException<T, E> = DataOrException<List<QueryItem<T>>, E>
typealias TravelDealsQueryResults = QueryResultsOrException<TravelDeal, Exception>