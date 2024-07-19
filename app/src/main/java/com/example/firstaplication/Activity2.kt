package com.example.firstaplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val textName: TextView = findViewById(R.id.textViewDatos)
        val name = intent.getStringExtra("Name")
        val lastName = intent.getStringExtra("LastName")
        val carnet = intent.getStringExtra("Carnet")

        textName.text = "Name: $name\nLast Name: $lastName\nCarnet: $carnet"
    }
}