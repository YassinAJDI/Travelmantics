package com.ajdi.yassin.travelmantics.utils

import com.google.firebase.database.FirebaseDatabase

/**
 * @author Yassin Ajdi
 * @since 8/4/2019.
 */
object FirebaseUtil {

    val database = FirebaseDatabase.getInstance()
    val dealsReference = database.getReference("travel_deals")
}