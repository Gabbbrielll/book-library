package com.example.finals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class library : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)


        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        val imageButton1 = findViewById<ImageButton>(R.id.imageButton1)
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        val imageButton3 = findViewById<ImageButton>(R.id.imageButton3)
        val imageButton4 = findViewById<ImageButton>(R.id.imageButton4)
        val imageButton5 = findViewById<ImageButton>(R.id.imageButton5)





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
        imageButton.setOnClickListener{
            val i = Intent(this,book1::class.java)
            startActivity(i)
        }
        imageButton1.setOnClickListener{
            val i = Intent(this,book2::class.java)
            startActivity(i)
        }
        imageButton2.setOnClickListener{
            val i = Intent(this,book3::class.java)
            startActivity(i)
        }
        imageButton3.setOnClickListener{
            val i = Intent(this,book4::class.java)
            startActivity(i)
        }
        imageButton4.setOnClickListener{
            val i = Intent(this,book5::class.java)
            startActivity(i)
        }
        imageButton5.setOnClickListener{
            val i = Intent(this,book6::class.java)
            startActivity(i)
        }
    }
    override fun onBackPressed() {
        val i = Intent(this, reading::class.java)
        startActivity(i)
        finish()
        super.onBackPressed()
    }

}