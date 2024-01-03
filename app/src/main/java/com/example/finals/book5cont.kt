package com.example.finals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.util.FitPolicy
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream

class book5cont : AppCompatActivity() {

    private lateinit var pdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book5cont)

        pdfView = findViewById(R.id.pdfView)

        val assetFileName = "boo5.pdf" // Change this to your PDF file in the assets folder
        displayFromAsset(assetFileName)
    }

    private fun displayFromAsset(assetFileName: String) {
        try {
            val assetManager = assets
            val inputStream: InputStream = assetManager.open(assetFileName)
            val bufferedInputStream = BufferedInputStream(inputStream)
            pdfView.fromStream(bufferedInputStream)
                .defaultPage(0)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .pageFitPolicy(FitPolicy.BOTH)
                .load()

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}