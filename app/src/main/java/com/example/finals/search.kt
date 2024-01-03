package com.example.finals

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast

class search : AppCompatActivity() {
    private lateinit var searchView: SearchView
    private lateinit var listViewBooks: ListView
    private lateinit var databaseHandler: DatabaseHandler
    private lateinit var books: List<Book> // Declare books as a property


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val clickableText = findViewById<TextView>(R.id.link)

        clickableText.setOnClickListener {
            // Define the URL to redirect to (in this case, Google)
            val googleUrl = "https://books.google.com/"

            // Create an Intent with the ACTION_VIEW action and the Google URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(googleUrl))

            // Start the activity to open the browser with the Google URL
            startActivity(intent)
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


        searchView = findViewById(R.id.searchView)
        listViewBooks = findViewById(R.id.listViewBooks)
        databaseHandler = DatabaseHandler(this)

        // Set up the SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrBlank()) {
                    searchBooks(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Handle text changes if needed
                return true
            }
        })

        // Set up item click listener for the ListView
        listViewBooks.setOnItemClickListener { _, _, position, _ ->
            val selectedBook = books[position]

            // Check the title of the selected book and redirect accordingly
            when (selectedBook.bookName) {
                "From Newton to Einstein" -> redirectToBook1()
                "Emma" -> redirectToBook2()
                "The Art of War" -> redirectToBook3()
                "A Tale of Two Cities" -> redirectToBook4()
                "Little Wars" -> redirectToBook5()
                "Walden" -> redirectToBook6()
                "Chess Strategy" -> redirectToBook7()
                "The Hacker's Dictionary" -> redirectToBook8()
                // Add more cases as needed for other titles
                else -> {
                    // Handle default case or show an error message
                    Toast.makeText(this, "Invalid book title", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Initialize books as empty list
        books = emptyList()
    }

    private fun searchBooks(bookTitle: String) {
        books = databaseHandler.searchBooks(bookTitle)
        if (books.isNotEmpty()) {
            // Display the search results in the ListView
            val adapter = BookAdapter(this, R.layout.book_list_item, books)
            listViewBooks.adapter = adapter
        } else {
            // Show a message if no books are found
            listViewBooks.adapter = null
            Toast.makeText(this, "No books found", Toast.LENGTH_SHORT).show()
        }
    }

    // Add these functions to your activity to handle redirection
    private fun redirectToBook1() {
        val intent = Intent(this, book1::class.java)
        startActivity(intent)
        finish()
    }

    private fun redirectToBook2() {
        val intent = Intent(this, book2::class.java)
        startActivity(intent)
        finish()
    }

    private fun redirectToBook3() {
        val intent = Intent(this, book3::class.java)
        startActivity(intent)
        finish()
    }
    private fun redirectToBook4() {
        val intent = Intent(this, book4::class.java)
        startActivity(intent)
        finish()
    }
    private fun redirectToBook5() {
        val intent = Intent(this, book5::class.java)
        startActivity(intent)
        finish()
    }
    private fun redirectToBook6() {
        val intent = Intent(this, book6::class.java)
        startActivity(intent)
        finish()
    }
    private fun redirectToBook7() {
        val intent = Intent(this, book7::class.java)
        startActivity(intent)
        finish()
    }
    private fun redirectToBook8() {
        val intent = Intent(this, book8::class.java)
        startActivity(intent)
        finish()
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
