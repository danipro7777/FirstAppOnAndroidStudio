package com.example.firstaplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewLastName: TextView = findViewById(R.id.textViewLastName)
        val textViewCarnet: TextView = findViewById(R.id.textViewCarnet)

        val name = intent.getStringExtra("Name")
        val lastName = intent.getStringExtra("LastName")
        val carnet = intent.getStringExtra("Carnet")

        textViewName.text = "Name: $name"
        textViewLastName.text = "Last Name: $lastName"
        textViewCarnet.text = "Carnet: $carnet"
    }
}