package com.example.movie_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movieList: List<Movie>, private val listener: OnItemClickListener) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(movie: Movie)
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val imageView: ImageView = itemView.findViewById(R.id.movie_image)
        private val titleTextView: TextView = itemView.findViewById(R.id.movie_title)
        private val ratingImageView: ImageView = itemView.findViewById(R.id.movie_rating_image)
        private val castTextView: TextView = itemView.findViewById(R.id.movie_cast)
        private val runningTimeTextView: TextView = itemView.findViewById(R.id.movie_running_time)
        private val seatsRemainingTextView: TextView = itemView.findViewById(R.id.movie_seats_remaining)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val movie = movieList[position]
                listener.onItemClick(movie)
            }
        }

        fun bind(item: Movie) {
            imageView.setImageResource(item.imageResId)
            titleTextView.text = item.title
            ratingImageView.setImageResource(item.ratingResId)
            castTextView.text = item.cast
            runningTimeTextView.text = item.runningTime
            seatsRemainingTextView.text = item.seatsRemaining.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount() = movieList.size
}