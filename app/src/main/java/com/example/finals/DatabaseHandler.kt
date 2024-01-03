package com.example.finals

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class User(
    val email: String,
    val firstName: String,
    val lastName: String,
    val username: String,
    val password: String
)

data class Book(
    val bookName: String,
    val author: String,
    val genre: String
)

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 2
        private const val DATABASE_NAME = "UserDatabase.db"

        private const val TABLE_USERS = "users"
        private const val KEY_EMAIL = "email_address"
        private const val KEY_FIRST_NAME = "first_name"
        private const val KEY_LAST_NAME = "last_name"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"

        // New table for books
        private const val TABLE_BOOKS = "books"
        private const val KEY_BOOK_NAME = "book_name"
        private const val KEY_AUTHOR = "author"
        private const val KEY_GENRE = "genre"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_USERS_TABLE = ("CREATE TABLE $TABLE_USERS (" +
                "$KEY_EMAIL TEXT PRIMARY KEY," +
                "$KEY_FIRST_NAME TEXT," +
                "$KEY_LAST_NAME TEXT," +
                "$KEY_USERNAME TEXT," +
                "$KEY_PASSWORD TEXT)")

        val CREATE_BOOKS_TABLE = ("CREATE TABLE $TABLE_BOOKS (" +
                "$KEY_BOOK_NAME TEXT PRIMARY KEY," +
                "$KEY_AUTHOR TEXT," +
                "$KEY_GENRE TEXT)")

        db?.execSQL(CREATE_USERS_TABLE)
        db?.execSQL(CREATE_BOOKS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_BOOKS")
        onCreate(db)
    }

    fun registerUser(email: String, fname: String, lname: String, username: String, password: String): Long {
        val db = this.writableDatabase
        return try {
            val values = ContentValues().apply {
                put(KEY_EMAIL, email)
                put(KEY_FIRST_NAME, fname)
                put(KEY_LAST_NAME, lname)
                put(KEY_USERNAME, username)
                put(KEY_PASSWORD, password)
            }
            db.insertOrThrow(TABLE_USERS, null, values)
        } catch (e: SQLException) {
            // Handle the error (e.g., log it or show a message)
            -1
        } finally {
            db.close()
        }
    }

    fun loginUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val selection = "$KEY_USERNAME = ? AND $KEY_PASSWORD = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null)

        val userExists = cursor.moveToFirst() && cursor.count > 0
        cursor.close()

        return userExists
    }

    fun getUserInfo(username: String): User? {
        val db = this.readableDatabase
        val selection = "$KEY_USERNAME = ?"
        val selectionArgs = arrayOf(username)
        val cursor: Cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null)

        return cursor.use {
            if (it.moveToFirst()) {
                val emailIndex = it.getColumnIndex(KEY_EMAIL)
                val firstNameIndex = it.getColumnIndex(KEY_FIRST_NAME)
                val lastNameIndex = it.getColumnIndex(KEY_LAST_NAME)
                val usernameIndex = it.getColumnIndex(KEY_USERNAME)
                val passwordIndex = it.getColumnIndex(KEY_PASSWORD)

                if (emailIndex != -1 && firstNameIndex != -1 && lastNameIndex != -1 &&
                    usernameIndex != -1 && passwordIndex != -1
                ) {
                    User(
                        it.getString(emailIndex),
                        it.getString(firstNameIndex),
                        it.getString(lastNameIndex),
                        it.getString(usernameIndex),
                        it.getString(passwordIndex)
                    )
                } else {
                    null
                }
            } else {
                null
            }
        }
    }

    fun addBook(bookName: String, author: String, genre: String): Long {
        val db = this.writableDatabase
        return try {
            val values = ContentValues().apply {
                put(KEY_BOOK_NAME, bookName)
                put(KEY_AUTHOR, author)
                put(KEY_GENRE, genre)
            }
            db.insertOrThrow(TABLE_BOOKS, null, values)
        } catch (e: SQLException) {
            // Handle the error (e.g., log it or show a message)
            -1
        } finally {
            db.close()
        }
    }

    // Add the searchBooks function
    fun searchBooks(bookTitle: String): List<Book> {
        val booksList = mutableListOf<Book>()
        val db = this.readableDatabase
        val selection = "$KEY_BOOK_NAME LIKE ?"
        val selectionArgs = arrayOf("%$bookTitle%")
        val cursor = db.query(TABLE_BOOKS, null, selection, selectionArgs, null, null, null)

        cursor.use {
            while (it.moveToNext()) {
                val bookIndex = it.getColumnIndex(KEY_BOOK_NAME)
                val authorIndex = it.getColumnIndex(KEY_AUTHOR)
                val genreIndex = it.getColumnIndex(KEY_GENRE)

                if (bookIndex != -1 && authorIndex != -1 && genreIndex != -1) {
                    val book = Book(
                        it.getString(bookIndex),
                        it.getString(authorIndex),
                        it.getString(genreIndex)
                    )
                    booksList.add(book)
                }
            }
        }

        return booksList
    }
}

