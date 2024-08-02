package com.example.firstaplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOk: Button = findViewById(R.id.btnOk)
        val txtName: EditText = findViewById(R.id.txtName)
        val txtLastName: EditText = findViewById(R.id.txtLastName)
        val txtCarnet: EditText = findViewById(R.id.txtCarnet)
        val buttonGoToWebView: Button = findViewById(R.id.buttonGoToWebView)
        val buttonGoToWebViewSpinnerA: Button = findViewById(R.id.buttonGoToWebViewSpinnerA)
        val btnPablo1: Button = findViewById(R.id.btnPablo1)

        btnOk.setOnClickListener {
            val name = txtName.text.toString()
            val lastName = txtLastName.text.toString()
            val carnet = txtCarnet.text.toString()

            if (name.isNotEmpty() && lastName.isNotEmpty() && carnet.isNotEmpty()) {
                val intent = Intent(this, Activity2::class.java).apply {
                    putExtra("Name", name)
                    putExtra("LastName", lastName)
                    putExtra("Carnet", carnet)
                }
                startActivity(intent)
                Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show()
            }
        }

        buttonGoToWebView.setOnClickListener {
            val intent = Intent(this, WebViewA::class.java)
            startActivity(intent)
        }

        buttonGoToWebViewSpinnerA.setOnClickListener {
            val intent = Intent(this, WebViewSpinnerA::class.java)
            startActivity(intent)
        }

        btnPablo1.setOnClickListener {
            val intent = Intent(this, WebViewPablo::class.java)
            startActivity(intent)
        }

        // Inicializar los Spinners
        val spinnerCarreras: Spinner = findViewById(R.id.spinner_carreras)
        val spinnerEstado: Spinner = findViewById(R.id.spinner_estado_civil)
        val spinnerDepartamentos: Spinner = findViewById(R.id.spinner_Departamentos)

        // Solicitar datos para el Spinner de departamentos
        Thread {
            try {
                val url = URL("https://987861fd25304ba59b9d2a49a2fa2271.api.mockbin.io/")
                val urlConnection = url.openConnection() as HttpURLConnection
                try {
                    val inputStream = BufferedReader(InputStreamReader(urlConnection.inputStream))
                    val response = inputStream.use { it.readText() }
                    val departamentosResponse = Gson().fromJson(response, DepartamentosResponse::class.java)

                    runOnUiThread {
                        val adapterDepartamentos = ArrayAdapter(this, android.R.layout.simple_spinner_item, departamentosResponse.Departamentos.distinct())
                        adapterDepartamentos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerDepartamentos.adapter = adapterDepartamentos
                    }
                } finally {
                    urlConnection.disconnect()
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Toast.makeText(this, "Failed to load departamentos data: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }.start()

        // Solicitar datos para el Spinner de carreras
        Thread {
            try {
                val url = URL("https://aea10539d99d4af0b7be5f4288f39b6e.api.mockbin.io/")
                val urlConnection = url.openConnection() as HttpURLConnection
                try {
                    val inputStream = BufferedReader(InputStreamReader(urlConnection.inputStream))
                    val response = inputStream.use { it.readText() }
                    val carrerasResponse = Gson().fromJson(response, CarrerasResponse::class.java)

                    runOnUiThread {
                        val adapterCarreras = ArrayAdapter(this, android.R.layout.simple_spinner_item, carrerasResponse.Carreras.distinct())
                        adapterCarreras.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerCarreras.adapter = adapterCarreras
                    }
                } finally {
                    urlConnection.disconnect()
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Toast.makeText(this, "Failed to load carreras data: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }.start()

        // Solicitar datos para el Spinner de estados
        Thread {
            try {
                val url = URL("https://6d9423fa6fff48d88737d621318ad639.api.mockbin.io/")
                val urlConnection = url.openConnection() as HttpURLConnection
                try {
                    val inputStream = BufferedReader(InputStreamReader(urlConnection.inputStream))
                    val response = inputStream.use { it.readText() }
                    val estadosResponse = Gson().fromJson(response, EstadosResponse::class.java)

                    runOnUiThread {
                        val adapterEstado = ArrayAdapter(this, android.R.layout.simple_spinner_item, estadosResponse.Estados.distinct())
                        adapterEstado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerEstado.adapter = adapterEstado
                    }
                } finally {
                    urlConnection.disconnect()
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Toast.makeText(this, "Failed to load estados data: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }.start()
    }
}

data class CarrerasResponse(val Carreras: List<String>)
data class EstadosResponse(val Estados: List<String>)
data class DepartamentosResponse(val Departamentos: List<String>)
