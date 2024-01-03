package com.example.finals


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class book8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book8)

        val btnBook8start = findViewById<Button>(R.id.btnBook8start)

        val btnbutton = findViewById<Button>(R.id.button)
        btnbutton.setOnClickListener {
            val intent = Intent(this, reading::class.java)
            startActivity(intent)
            finish()
        }

        btnBook8start.setOnClickListener{
            val i = Intent(this,book8cont::class.java)
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