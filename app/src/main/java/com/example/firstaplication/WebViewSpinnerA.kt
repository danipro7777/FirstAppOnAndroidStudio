package com.example.firstaplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebViewSpinnerA : AppCompatActivity() {

    private lateinit var spinnerURL: Spinner
    private lateinit var buttonOpenURL: Button
    private lateinit var webView: WebView
    private lateinit var selectedURL: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webviewangy2)

        spinnerURL = findViewById(R.id.spinnerURL)
        buttonOpenURL = findViewById(R.id.buttonOpenURL)
        webView = findViewById(R.id.webView)

        // Configurar WebView para soportar JavaScript
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        // Configurar el Spinner con nombres de sitios web y sus URLs
        val sites = mapOf(
            "Google" to "https://www.google.com",
            "Instagram" to "https://www.instagram.com/",
            "Facebook" to "https://www.facebook.com/?locale=es_LA",
            "Mesoamericana" to "https://www.mesoamericana.edu.gt/"
        )

        val siteNames = sites.keys.toList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, siteNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerURL.adapter = adapter

        spinnerURL.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedSiteName = parent.getItemAtPosition(position).toString()
                selectedURL = sites[selectedSiteName] ?: ""
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No hacer nada
            }
        }

        buttonOpenURL.setOnClickListener {
            if (selectedURL.isNotEmpty()) {
                webView.loadUrl(selectedURL)
            } else {
                // Manejar error si no hay URL seleccionada
            }
        }
    }
}
