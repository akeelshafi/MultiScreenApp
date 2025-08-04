package com.akeel.multiscreenapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Order

class MainActivity : AppCompatActivity() {

    // creating key
    companion object {
        const val KEY = "com.akeel.multiscreenapp.MainActivity.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val eT1 = findViewById<EditText>(R.id.eT1)
        val eT2 = findViewById<EditText>(R.id.eT2)
        val eT3 = findViewById<EditText>(R.id.eT3)
        val eT4 = findViewById<EditText>(R.id.eT4)

        btnOrder.setOnClickListener {
            val orderPlaced =
                eT1.text.toString() + " " + eT2.text.toString() + " " + eT3.text.toString() + " " + eT4.text.toString()
            intent = Intent(this, Order::class.java)
            intent.putExtra(KEY, orderPlaced)
            startActivity(intent)

        }
    }
}