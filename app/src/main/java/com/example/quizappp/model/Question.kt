package com.example.quizappp.model

data class Question(
    val id: Int,
    val ques: String,
    val img : Int,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAns: Int

)