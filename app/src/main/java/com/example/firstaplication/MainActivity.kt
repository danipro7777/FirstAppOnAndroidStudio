package com.example.firstaplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
    }
}
