package com.example.firstaplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnOk: Button=findViewById(R.id.btnOk)
        btnOk.setOnClickListener {
            val intent=Intent(this, Activity2::class.java)
            intent.putExtra("Name", "Daniel")
            startActivity(intent)
            Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show()
        }

    }
}