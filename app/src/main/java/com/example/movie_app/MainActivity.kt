package com.example.movie_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the RecyclerView in your layout file
        recyclerView = findViewById(R.id.movie_recycler_view)

        // Create a LinearLayoutManager to manage the items in the RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a MovieAdapter to bind the movie data to the views in the RecyclerView
        val movieList = createMovieList()
        movieAdapter = MovieAdapter(movieList)
        recyclerView.adapter = movieAdapter
    }

    private fun createMovieList(): List<Movie> {
        // Image Source: https://www.rogerebert.com/reviews/
        // Content Source: https://www.myvue.com/
        return listOf(
            Movie(
                R.drawable.creed3_poster,
                "Creed III",
                R.drawable.tbc,
                "When a childhood friend and former boxing prodigy, Damian (Jonathan Majors), resurfaces after serving a long sentence in prison, he is eager to prove that he deserves his shot in the ring.",
                "Michael B. Jordan, Tessa Thompson, Jonathan Majors, Wood Harris",
                "116 mins",
                Movie.generateRandomSeatsRemaining()
            ),
            Movie(
                R.drawable.john_wick,
                "John Wick: Chapter 4",
                R.drawable.sixteen,
                "John Wick (Keanu Reeves) uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes. ",
                "Keanu Reeves, Donnie Yen, Bill Skarsgård",
                "169 mins",
                Movie.generateRandomSeatsRemaining()
            ),
            Movie(
                R.drawable.dungeons_and_dragons,
                "Dungeons and Dragons: Honour Among Thieves",
                R.drawable.tbc,
                "A charming thief and a band of unlikely adventurers undertake an epic heist to retrieve a lost relic, but things go dangerously awry when they run afoul of the wrong people.",
                "Chris Pine, Michelle Rodriguez, Justice Smith, Regé-Jean Page, Sophia Lillis, Chloe Coleman, Daisy Head, Hugh Grant",
                "134 mins",
                Movie.generateRandomSeatsRemaining()
            ),
            Movie(
                R.drawable.super_marios_bros,
                "The Super Mario Bros. Movie",
                R.drawable.pg,
                "A plumber named Mario travels through an underground labyrinth with his brother, Luigi, trying to save a captured princess.",
                "Chris Pratt, Anya Taylor-Joy, Charlie Day, Jack Black, Seth Rogen",
                "92 mins",
                Movie.generateRandomSeatsRemaining()
            ),
)
    }
}