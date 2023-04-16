package com.example.movie_app

import java.util.*

data class Movie(
    val imageResId: Int,
    val title: String,
    val ratingResId: Int,
    val cast: String, //Movie Details only
    val runningTime: String,
    val description: String,
    val seatsRemaining: Int,
) {
    companion object {
        private val RANDOM = Random()

        fun generateRandomSeatsRemaining(): Int {
            return RANDOM.nextInt(16)
        }

    }

    operator fun get(position: Int): Any? {
        return when (position) {
            0 -> imageResId
            1 -> title
            2 -> ratingResId
            3 -> cast
            4 -> runningTime
            5 -> description
            6 -> seatsRemaining
            else -> null
        }
    }
}
