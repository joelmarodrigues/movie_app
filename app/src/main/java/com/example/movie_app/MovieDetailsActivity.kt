package com.example.movie_app

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        // Get data from the intent
        val title = intent.getStringExtra("MOVIE_TITLE")
        val imageResId = intent.getIntExtra("MOVIE_IMAGE_RES_ID", 0)
        val ratingResId = intent.getIntExtra("MOVIE_RATING_RES_ID", 0)
        val cast = intent.getStringExtra("MOVIE_CAST")
        val runningTime = intent.getStringExtra("MOVIE_RUNNING_TIME")
        val seatsRemaining = intent.getIntExtra("MOVIE_SEATS_REMAINING", 0)

        // Set the movie details
        findViewById<ImageView>(R.id.movie_image_details).setImageResource(imageResId)
        findViewById<TextView>(R.id.movie_title_detail).text = title
        findViewById<ImageView>(R.id.movie_rating_image_detail).setImageResource(ratingResId)
        findViewById<TextView>(R.id.movie_cast_detail).text = cast
        findViewById<TextView>(R.id.movie_running_time_detail).text = runningTime
        findViewById<TextView>(R.id.movie_seats_remaining_detail).text = seatsRemaining.toString()

        // Add click listeners to the add and minus icons
        val minusIcon = findViewById<ImageView>(R.id.minus_icon_detail)
        val addIcon = findViewById<ImageView>(R.id.add_icon_detail)
        val seatsSelectedTextView = findViewById<TextView>(R.id.seats_selected_detail)

        minusIcon.setOnClickListener {
            var seatsSelected = seatsSelectedTextView.text.toString().toInt()
            if (seatsSelected > 0) {
                seatsSelected--
                seatsSelectedTextView.text = seatsSelected.toString()
            }
        }

        addIcon.setOnClickListener {
            var seatsSelected = seatsSelectedTextView.text.toString().toInt()
            seatsSelected++
            seatsSelectedTextView.text = seatsSelected.toString()
        }
    }
}
