package com.example.libraryapp

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class PdfViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)

        val pdfName = intent.getStringExtra("pdfName") ?: return
        val pdfWebView = findViewById<WebView>(R.id.pdfWebView)

        // Configure WebView settings
        val settings: WebSettings = pdfWebView.settings
        settings.javaScriptEnabled = true
        settings.allowFileAccessFromFileURLs = true

        // Load PDF file into WebView from GitHub Pages
        val pdfUrl = "https://krupasai1.github.io/Library-App/assets/$pdfName.pdf"
        pdfWebView.loadUrl("https://docs.google.com/gview?embedded=true&url=$pdfUrl")
    }
}

