package com.example.quizappp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizappp.R
import com.example.quizappp.model.Question
import com.example.quizappp.utils.Constants

class QuesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var ProgressBar : ProgressBar
    private lateinit var ProgressText: TextView
    private lateinit var TextQues : TextView
    private lateinit var Image: ImageView
    private lateinit var Option1: TextView
    private lateinit var Option2: TextView
    private lateinit var Option3: TextView
    private lateinit var Option4: TextView
    private lateinit var BtnCheck: Button
    private  val currentQues = 1
    private lateinit var quesList : MutableList<Question>
    private var quesCounter = 0
    private var selectedAns = 0
    private  lateinit var currentQuesVal: Question
    private var answered = false

    private lateinit var name: String
    private  var score=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ques)

        ProgressBar = findViewById(R.id.progressBar)
        ProgressText  = findViewById(R.id.amt_of_porgress)
        TextQues  = findViewById(R.id.Ques_heading)
        Image = findViewById(R.id.ques_img)
        Option1 = findViewById(R.id.text_ques1)
        Option2 = findViewById(R.id.text_ques2)
        Option3 = findViewById(R.id.text_ques3)
        Option4 = findViewById(R.id.text_ques4)
        BtnCheck = findViewById(R.id.Check_ans)

        Option1.setOnClickListener(this)
        Option2.setOnClickListener(this)
        Option3.setOnClickListener(this)
        Option4.setOnClickListener(this)
        BtnCheck.setOnClickListener(this)

        quesList = Constants.getQuestions()
//        Log.d("QuestionSize", "${quesList.size}")
        showNextQues()

        if(intent.hasExtra(Constants.user_name)){
            name=intent.getStringExtra(Constants.user_name)!!
        }

    }
    private fun showNextQues(){
        resetOptBorder()        // ✅ add this
        selectedAns = 0
        val ques = quesList[quesCounter]
        currentQuesVal = ques
        Image.setImageResource(ques.img)
        ProgressBar.progress = quesCounter + 1
        ProgressText.text = "${quesCounter }/${quesList.size}"
        TextQues.text = ques.ques
        Option1.text = ques.option1
        Option2.text = ques.option2
        Option3.text = ques.option3
        Option4.text = ques.option4


        if(currentQues==quesList.size)
        {
            BtnCheck.text="Finish"

        }else{
            BtnCheck.text= getString(R.string.check_ans)
        }
        answered=false
    }

    private fun resetOptBorder(){
        val options = mutableListOf<TextView>()
        options.add(Option1)
        options.add(Option2)
        options.add(Option3)
        options.add(Option4)

        for(option in options){
            option.setTextColor(Color.parseColor("#515250"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_border_option
            )
        }
    }


    private fun selectOPtBorder(textView: TextView,selectedOptionNumber: Int){
        resetOptBorder()
        selectedAns = selectedOptionNumber
        textView.setTextColor(Color.parseColor("#411D7A"))
        textView.setTypeface(textView.typeface,Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_border_option
        )
    }


    override fun onClick(v: View?) {
           when(v?.id){
                R.id.text_ques1 -> {
                    selectOPtBorder(Option1,1)
                }
               R.id.text_ques2 -> {
                   selectOPtBorder(Option2,2)
               }
               R.id.text_ques3 -> {
                   selectOPtBorder(Option3,3)
               }
               R.id.text_ques4 -> {
                   selectOPtBorder(Option4,4)
               }
               R.id.Check_ans -> {

                   if(selectedAns == 0){
                       return
                   }

                   if(!answered){
                       checkAns()
                   } else {

                       if(quesCounter < quesList.size - 1){
                           quesCounter++
                           showNextQues()
                       } else {
                           // LAST QUESTION → GO TO RESULT PAGE
                           val intent = Intent(this, ResultActivity::class.java)
                           intent.putExtra(Constants.user_name, name)
                           intent.putExtra(Constants.score, score)
                           intent.putExtra(Constants.Total_ques,quesList.size)
                           startActivity(intent)
                           finish()
                       }
                   }
               }

           }
    }

    private fun checkAns(){
         answered=true
        if(selectedAns==currentQuesVal.correctAns){
            score++
            when(selectedAns){
                1->{
                    Option1.background= ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_ans_bg
                    )
                }
                2->{
                    Option2.background= ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_ans_bg
                    )
                }
                3->{
                    Option3.background= ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_ans_bg
                    )
                }
                4->{
                    Option4.background= ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_ans_bg
                    )
                }
            }
        }else{
            when(selectedAns){
                1->{
                    Option1.background= ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_ans_bg
                    )
                }
                2->{
                    Option2.background= ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_ans_bg
                    )
                }
                3->{
                    Option3.background= ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_ans_bg
                    )
                }
                4->{
                    Option4.background= ContextCompat.getDrawable(
                        this,
                        R.drawable.wrong_ans_bg
                    )
                }
            }
        }
        BtnCheck.text = "Next"
        showSolution()
    }

    private fun showSolution(){
        selectedAns = currentQuesVal.correctAns

        when(selectedAns){
            1->{
                Option1.background= ContextCompat.getDrawable(
                    this,
                    R.drawable.correct_ans_bg
                )
            }
            2->{
                Option2.background= ContextCompat.getDrawable(
                    this,
                    R.drawable.correct_ans_bg
                )
            }
            3->{
                Option3.background= ContextCompat.getDrawable(
                    this,
                    R.drawable.correct_ans_bg
                )
            }
            4->{
                Option4.background= ContextCompat.getDrawable(
                    this,
                    R.drawable.correct_ans_bg
                )
            }
        }


    }
}