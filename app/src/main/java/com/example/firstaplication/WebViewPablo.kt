package com.example.firstaplication

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class WebViewPablo : AppCompatActivity() {

    private lateinit var editTextURL: EditText
    private lateinit var buttonOpenURL: Button
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webviewpablo)

        editTextURL = findViewById(R.id.editTextURL)
        buttonOpenURL = findViewById(R.id.buttonOpenURL)
        webView = findViewById(R.id.webview)

        // Configurar WebView para soportar JavaScript
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        buttonOpenURL.setOnClickListener {
            var url = editTextURL.text.toString()
            if (url.isNotEmpty()) {
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://$url"
                }
                webView.loadUrl(url)
            } else {
                editTextURL.error = "Por favor ingrese una URL"
            }
        }
    }
}
