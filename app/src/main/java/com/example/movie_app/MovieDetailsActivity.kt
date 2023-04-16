package com.example.movie_app

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        // Movie Details
        val title = intent.getStringExtra("MOVIE_TITLE")
        val imageResId = intent.getIntExtra("MOVIE_IMAGE_RES_ID", 0)
        val ratingResId = intent.getIntExtra("MOVIE_RATING_RES_ID", 0)
        val cast = intent.getStringExtra("MOVIE_CAST")
        val runningTime = intent.getStringExtra("MOVIE_RUNNING_TIME")
        val description = intent.getStringExtra("MOVIE_DESCRIPTION")
        val seatsRemaining = intent.getIntExtra("MOVIE_SEATS_REMAINING", 0)

        // Movie details
        findViewById<ImageView>(R.id.movie_image_details).setImageResource(imageResId)
        findViewById<TextView>(R.id.movie_title_detail).text = title
        findViewById<ImageView>(R.id.movie_rating_image_detail).setImageResource(ratingResId)
        findViewById<TextView>(R.id.movie_cast_detail).text = cast
        findViewById<TextView>(R.id.movie_running_time_detail).text = runningTime
        findViewById<TextView>(R.id.movie_description).text = description
        findViewById<TextView>(R.id.movie_seats_remaining_detail).text = seatsRemaining.toString()

        // Click listeners - add and minus icons
        val minusIcon = findViewById<ImageView>(R.id.minus_icon_detail)
        val addIcon = findViewById<ImageView>(R.id.add_icon_detail)
        val seatsSelectedTextView = findViewById<TextView>(R.id.seats_selected_detail)

        minusIcon.setOnClickListener {
            var seatsSelected = seatsSelectedTextView.text.toString().toInt()
            if (seatsSelected > 0) {
                seatsSelected--
                seatsSelectedTextView.text = seatsSelected.toString()
            }

            // Update the color of the add icon if seats selected equals seats remaining
            if (seatsSelected == seatsRemaining) {
                addIcon.setColorFilter(ContextCompat.getColor(this, R.color.grey))
            } else {
                addIcon.clearColorFilter()
            }

            // Minus icon changes color to grey if seats selected is zero
            if (seatsSelected == 0) {
                minusIcon.setColorFilter(ContextCompat.getColor(this, R.color.grey))
            } else {
                minusIcon.clearColorFilter()
            }
        }

        addIcon.setOnClickListener {
            var seatsSelected = seatsSelectedTextView.text.toString().toInt()
            if (seatsSelected < seatsRemaining) {
                seatsSelected++
                seatsSelectedTextView.text = seatsSelected.toString()

                // Minus icon = grey if seats selected is greater than zero
                if (seatsSelected > 0) {
                    minusIcon.clearColorFilter()
                }

                // Add icon if seats selected equals seats remaining
                if (seatsSelected == seatsRemaining) {
                    addIcon.setColorFilter(ContextCompat.getColor(this, R.color.grey))
                } else {
                    addIcon.clearColorFilter()
                }
            }
        }
    }
}