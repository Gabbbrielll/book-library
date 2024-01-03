package com.example.finals

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.finals.Book

class BookAdapter(context: Context, resource: Int, objects: List<Book>) :
    ArrayAdapter<Book>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.book_list_item, parent, false)

        val book = getItem(position)
        val textBookName = view.findViewById<TextView>(R.id.textBookName)
        val textAuthor = view.findViewById<TextView>(R.id.textAuthor)
        val textGenre = view.findViewById<TextView>(R.id.textGenre)

        textBookName.text = book?.bookName
        textAuthor.text = book?.author
        textGenre.text = book?.genre

        return view
    }
}