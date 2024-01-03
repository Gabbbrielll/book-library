package com.example.finals

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class AddBookInfoActivity : AppCompatActivity() {

    private lateinit var dbHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book_info)

        dbHandler = DatabaseHandler(this)

        val buttonAddBook = findViewById<Button>(R.id.buttonAddBook)

        buttonAddBook.setOnClickListener {
            val editTextBookName = findViewById<EditText>(R.id.editTextBookName)
            val editTextAuthor = findViewById<EditText>(R.id.editTextAuthor)
            val editTextGenre = findViewById<EditText>(R.id.editTextGenre)

            val title = editTextBookName.text.toString()
            val author = editTextAuthor.text.toString()
            val genre = editTextGenre.text.toString()

            if (title.trim().isNotEmpty() && author.trim().isNotEmpty() && genre.trim().isNotEmpty()) {
                val registrationSuccess = dbHandler.addBook(title, author, genre)

                if (registrationSuccess != -1L) {
                    // Successfully added to the database
                    Toast.makeText(this, "Book Added Successfully", Toast.LENGTH_LONG).show()

                    // Handle UI updates or navigate to a different part of your app
                    // For example, you can finish the current activity or go back to the previous activity
                    finish()
                } else {
                    // Handle the case where the book was not added successfully
                    Toast.makeText(this, "Failed to add book", Toast.LENGTH_LONG).show()
                }

                // Clear the input fields
                editTextBookName.text.clear()
                editTextAuthor.text.clear()
                editTextGenre.text.clear()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun onBackPressed() {
        // Handle back button press
        // For example, navigate to the previous activity
        val i = Intent(this, reading::class.java)
        startActivity(i)
        finish() // finish current activity
        super.onBackPressed() // call the default back button behavior
    }
}
