package com.example.quizappp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizappp.ui.QuesActivity
import com.example.quizappp.utils.Constants


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val start_btn : Button = findViewById(R.id.button_Start)
    val editText : EditText = findViewById(R.id.name)

    start_btn.setOnClickListener {
        if(!editText.text.isEmpty()){
            Intent(this@MainActivity, QuesActivity ::class.java).also{
                it.putExtra(Constants.user_name,editText.text.toString())
                startActivity(it)
                finish()
            }
        }else{
            Toast.makeText(this@MainActivity, "Enter User Name", Toast.LENGTH_LONG).show()
        }
    }
    }
}