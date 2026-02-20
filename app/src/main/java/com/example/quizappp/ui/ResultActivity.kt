package com.example.quizappp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizappp.MainActivity
import com.example.quizappp.R
import com.example.quizappp.utils.Constants

class ResultActivity : AppCompatActivity() {
    private lateinit var username: TextView
    private lateinit var score: TextView
    private lateinit var finish_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

    username=findViewById(R.id.Username)
    score=findViewById(R.id.score)
    finish_btn=findViewById(R.id.finish)

    val totalQues = intent.getIntExtra(Constants.Total_ques,0)
    val correctScore= intent.getIntExtra(Constants.score,0)
    val name= intent.getStringExtra(Constants.user_name)

    score.text="Your score is $correctScore out of $totalQues"
    username.text = name

    finish_btn.setOnClickListener {
        Intent(this, MainActivity::class.java).also{
             startActivity(it)
        }
    }

    }
}