package com.example.movie_app
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.movie_image)
        val titleTextView: TextView = itemView.findViewById(R.id.movie_title)
        val ratingImageView: ImageView = itemView.findViewById(R.id.movie_rating_image)
        val castTextView: TextView = itemView.findViewById(R.id.movie_cast)
        val runningTimeTextView: TextView = itemView.findViewById(R.id.movie_running_time)
        val seatsRemainingTextView: TextView = itemView.findViewById(R.id.movie_seats_remaining)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = movieList[position]

        holder.imageView.setImageResource(currentItem.imageResId)
        holder.titleTextView.text = currentItem.title
        holder.ratingImageView.setImageResource(currentItem.ratingResId)
        holder.castTextView.text = currentItem.cast
        holder.runningTimeTextView.text = currentItem.runningTime
        holder.seatsRemainingTextView.text = currentItem.seatsRemaining.toString()

    }

    override fun getItemCount() = movieList.size
}
