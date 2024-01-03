package com.example.finals


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class book7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book7)

        val btnBook7start = findViewById<Button>(R.id.btnBook7start)

        val btnbutton = findViewById<Button>(R.id.button)
        btnbutton.setOnClickListener {
            val intent = Intent(this, reading::class.java)
            startActivity(intent)
            finish()
        }


        btnBook7start.setOnClickListener{
            val i = Intent(this,book7cont::class.java)
            startActivity(i)
        }
    }
    override fun onBackPressed() {
        val i = Intent(this, library::class.java)
        startActivity(i)
        finish()
        super.onBackPressed()
    }
}