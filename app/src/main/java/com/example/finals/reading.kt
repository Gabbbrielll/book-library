package com.example.finals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class reading : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reading)


        val tvName = findViewById<TextView>(R.id.tvName)
        val imageButton1 = findViewById<ImageButton>(R.id.imageButton1)
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        val ITC3 = findViewById<TextView>(R.id.ITC3)
        val bundle = intent.extras
        //val firstName =
        //val lastName =

        if (bundle != null) {
            tvName.text = "${bundle.getString("FIRST_NAME")} ${bundle.getString("LAST_NAME")}"
        }

        imageButton1.setOnClickListener{
            val i = Intent(this,book7::class.java)
            startActivity(i)
        }

        imageButton2.setOnClickListener{
            val i = Intent(this,book8::class.java)
            startActivity(i)
        }
        ITC3.setOnClickListener{
            val i = Intent(this, AddBookInfoActivity::class.java)
            startActivity(i)
        }

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



    }
    override fun onBackPressed() {
        val i = Intent(this, reading::class.java)
        startActivity(i)
        finish()
        super.onBackPressed()
    }

}