package com.ajdi.yassin.travelmantics.utils

import com.ajdi.yassin.travelmantics.data.model.TravelDeal
import com.google.firebase.database.DataSnapshot

/**
 * @author Yassin Ajdi
 * @since 8/7/2019.
 */
class TravelDealSnapshotDeserializer {
    fun deserialize(input: DataSnapshot): TravelDeal {
        val data = input.value
        return if (data is Map<*, *>) {
            val pushKey = input.key!!

            val title = data["title"]
                ?: throw RuntimeException("price was missing for stock price snapshot $pushKey")

            val description = data["description"]
                ?: throw RuntimeException("time was missing for stock price snapshot $pushKey")

            val price = data["price"]
                ?: throw RuntimeException("time was missing for stock price snapshot $pushKey")

            val imageUrl = data["imageUrl"]
                ?: throw RuntimeException("time was missing for stock price snapshot $pushKey")

            TravelDeal(pushKey, title.toString(), description.toString(), price.toString(), imageUrl.toString())
        } else {
            throw RuntimeException("DataSnapshot value wasn't an object Map")
        }
    }
}