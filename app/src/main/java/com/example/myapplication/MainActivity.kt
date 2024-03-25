package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mcqbtn: Button = findViewById(R.id.mcq_button)
        val truefalsebtn : Button = findViewById(R.id.true_false_button)
        val ratebtn: Button = findViewById(R.id.rate_button)


        mcqbtn.setOnClickListener {
            val intent = Intent(this, McqQuiz::class.java)
            startActivity(intent)
        }
        truefalsebtn.setOnClickListener {
            val intent = Intent(this, TrueFalseActivity::class.java)
            startActivity(intent)
        }
        ratebtn.setOnClickListener {
            val intent = Intent(this, RatingActiivty::class.java)
            startActivity(intent)
        }
    }
}