package com.example.myapplication
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class RatingActiivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rating_activity)

        // Initiate the RatingBar
        val simpleRatingBar = findViewById<RatingBar>(R.id.RatingBar1)

        // Get the rating value and total number of stars
        val rating = simpleRatingBar.rating
        val totalStars = simpleRatingBar.numStars

        // Display the rating value and total number of stars
        Toast.makeText(this, "Rating: $rating / $totalStars", Toast.LENGTH_SHORT).show()
    }
}
