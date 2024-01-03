package com.example.finals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class favorites : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val btnreading = findViewById<Button>(R.id.reading)
        btnreading.setOnClickListener {
            val intent = Intent(this, reading::class.java)
            startActivity(intent)
            finish()
        }
        val btnlibrary = findViewById<Button>(R.id.library)
        btnlibrary.setOnClickListener {
            val intent = Intent(this, library::class.java)
            startActivity(intent)
            finish()
        }
        val btnfavorites = findViewById<Button>(R.id.favorites)
        btnfavorites.setOnClickListener {
            val intent = Intent(this, favorites::class.java)
            startActivity(intent)
            finish()
        }
        val btnsearch = findViewById<Button>(R.id.search)
        btnsearch.setOnClickListener {
            val intent = Intent(this, search::class.java)
            startActivity(intent)
            finish()
        }
        val btnprofile = findViewById<Button>(R.id.profile)
        btnprofile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
            finish()
        }

    }

}