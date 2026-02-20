package com.example.quizappp.utils

import com.example.quizappp.R
import com.example.quizappp.model.Question

object Constants{

    const val user_name = "username"
    const val Total_ques = "total_ques"
    const val score = "Score"
    fun getQuestions(): MutableList<Question>{
         val questions = mutableListOf<Question>()

        val ques1 = Question(
            1,
            "Identify the image!",
            R.drawable.apricot,
            "Apricot",
            "Guava",
            "Mango" ,
            "Lichi",
            1,
        )
        questions.add(ques1)

        val ques2 = Question(
            2,
            "Identify the image!",
            R.drawable.grapes,
            "Grapes",
            "Apricot",
            "Mango" ,
            "Apple",
            1,
        )
        questions.add(ques2)

        val ques3 = Question(
            2,
            "Identify the image!",
            R.drawable.guava,
            "Litchi",
            "Apricot",
            "Mango" ,
            "Guava",
            4,
        )
        questions.add(ques3)

        val ques4 = Question(
            2,
            "Identify the image!",
            R.drawable.mango,
            "Kiwi",
            "Apricot",
            "Mango" ,
            "Apple",
            3,
        )
        questions.add(ques4)

        val ques5 = Question(
            2,
            "Identify the image!",
            R.drawable.orange,
            "Grapes",
            "Apricot",
            "Orange" ,
            "Cherry",
            3,
        )
        questions.add(ques5)

        val ques6 = Question(
            2,
            "Identify the image!",
            R.drawable.papaya,
            "Litchi",
            "Apricot",
            "Papaya" ,
            "Guava",
            3,
        )
        questions.add(ques6)

        val ques7 = Question(
            2,
            "Identify the image!",
            R.drawable.pineapple,
            "Papaya",
            "Pineapple",
            "Mango" ,
            "Kiwi",
            2,
        )
        questions.add(ques7)

        val ques8 = Question(
            2,
            "Identify the image!",
            R.drawable.pomegranate,
            "Pomegranate",
            "Lemon",
            "Mango" ,
            "Orange",
            1,
        )
        questions.add(ques8)

        val ques9 = Question(
            2,
            "Identify the image!",
            R.drawable.pumpkin,
            "Spinach",
            "Apricot",
            "Pumpkin" ,
            "Apple",
            3,
        )
        questions.add(ques9)

        val ques10 = Question(
            2,
            "Identify the image!",
            R.drawable.tomato,
            "Litchi",
            "Tomato",
            "Mango" ,
            "Guava",
            2,
        )
        questions.add(ques10)



        return questions
    }

}