package com.example.firstaplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOk: Button = findViewById(R.id.btnOk)
        val txtName: EditText = findViewById(R.id.txtName)
        val txtLastName: EditText = findViewById(R.id.txtLastName)
        val txtCarnet: EditText = findViewById(R.id.txtCarnet)

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

        val stringArrayCarreras = arrayOf("Ingenieria", "Medicine", "Licenciatura")

        val spinner: Spinner = findViewById(R.id.spinner_carreras)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, stringArrayCarreras)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        val JsonString: String = "{\n" +
                "  \"Estados\": [\n" +
                "    \"Soltero\",\n" +
                "    \"Casado\",\n" +
                "    \"Divorciado\"\n" +
                "]\n" +
                "}"


        val gson = Gson()
        val itemsResponse = gson.fromJson(JsonString, Estados::class.java)

        val spinnerEstado: Spinner = findViewById(R.id.spinner_estado_civil)
        val adapterEstado = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsResponse.Estados)
        adapterEstado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerEstado.adapter = adapterEstado
    }
}
