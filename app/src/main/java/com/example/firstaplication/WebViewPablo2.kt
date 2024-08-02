package com.example.firstaplication

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class WebViewPablo2 : AppCompatActivity() {

    private lateinit var spinnerURLs: Spinner
    private lateinit var buttonLoadURL: Button
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webviewpablo2)  // Asegúrate de usar el layout correcto aquí

        spinnerURLs = findViewById(R.id.spinnerURLs)
        buttonLoadURL = findViewById(R.id.buttonLoadURL)
        webView = findViewById(R.id.webview)

        // Configurar WebView para soportar JavaScript
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        // Configurar Spinner con opciones
        val urls = arrayOf("https://www.youtube.com", "https://www.google.com", "https://www.facebook.com")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, urls)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerURLs.adapter = adapter

        buttonLoadURL.setOnClickListener {
            val selectedURL = spinnerURLs.selectedItem.toString()
            webView.loadUrl(selectedURL)
        }
    }
}
