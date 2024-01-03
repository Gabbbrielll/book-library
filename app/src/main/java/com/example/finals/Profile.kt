package com.example.finals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val firstName = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")
        val email = intent.getStringExtra("EMAIL")
        val username = intent.getStringExtra("USERNAME")
        val tvEmail = findViewById<TextView>(R.id.email)
        val tvName = findViewById<TextView>(R.id.fn)
        val tvUsername = findViewById<TextView>(R.id.user)

        tvName.text = "$firstName $lastName"
        tvEmail.text = email
        tvUsername.text = username



        val btnback = findViewById<Button>(R.id.backbtn)
        btnback.setOnClickListener {
            val intent = Intent(this, reading::class.java)
            startActivity(intent)
            finish()
        }
        val btnlogout = findViewById<Button>(R.id.logout)
        btnlogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}