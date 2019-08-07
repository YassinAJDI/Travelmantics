package com.ajdi.yassin.travelmantics.utils

import com.ajdi.yassin.travelmantics.data.model.DataOrException
import com.google.firebase.database.*


/**
 * @author Yassin Ajdi
 * @since 8/5/2019.
 */
class RealtimeDatabaseQueryLiveData : LingeringLiveData<DataSnapshotOrException>, ValueEventListener {

    private val LOG_TAG = "DatabaseQueryLiveData"
    private val query: Query

    constructor(query: Query) {
        this.query = query
    }

    constructor(ref: DatabaseReference) {
        this.query = ref
    }

    override fun beginLingering() {
        query.addValueEventListener(this)
    }

    override fun endLingering() {
        query.removeEventListener(this)
    }

    override fun onDataChange(dataSnapshot: DataSnapshot) {
        value = DataOrException(dataSnapshot, null)
    }

    override fun onCancelled(error: DatabaseError) {
        value = DataOrException(null, error.toException())
    }
}