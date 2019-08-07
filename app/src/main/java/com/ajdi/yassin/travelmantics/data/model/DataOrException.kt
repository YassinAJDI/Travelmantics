package com.ajdi.yassin.travelmantics.data.model

/**
 * @author Yassin Ajdi
 * @since 8/7/2019.
 */
data class DataOrException<out T, out E: Exception?>(val data: T?, val exception: E?) {
    init {
        if (data == null && exception == null) {
            throw IllegalArgumentException("Both data and exception can't be null")
        }
        else if (data != null && exception != null) {
            throw IllegalArgumentException("Both data and exception can't be non-null")
        }
    }
}