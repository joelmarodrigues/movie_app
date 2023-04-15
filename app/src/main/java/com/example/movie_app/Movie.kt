package com.example.movie_app

import java.util.*

data class Movie(
    val imageResId: Int,
    val title: String,
    val ratingResId: Int,
    val description: String,
    val cast: String,
    val runningTime: String,
    val seatsRemaining: Int,
)
{
    companion object {
        private val RANDOM = Random()

        fun generateRandomSeatsRemaining(): Int {
            return RANDOM.nextInt(16)
        }
    }
}