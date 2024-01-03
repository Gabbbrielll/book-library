package com.example.finals

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class book2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book2)

        val btnBook2start = findViewById<Button>(R.id.btnBook2start)

        val btnbutton = findViewById<Button>(R.id.button)
        btnbutton.setOnClickListener {
            val intent = Intent(this, library::class.java)
            startActivity(intent)
            finish()
        }


        btnBook2start.setOnClickListener{
            val i = Intent(this,book2cont::class.java)
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