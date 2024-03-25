package com.example.myapplication
import android.content.Intent
import android.os.Bundle

import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TrueFalseActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.truefalse_activity)
        data class Question(
            val questionText: String,
            val correctAnswer: Boolean
        )
        val questions: List<Question> = listOf(
            Question(
                "The national animal of Pakistan is the Markhor.",
                true
            ),
            Question(
                "Urdu is the only official language of Pakistan.",
                false
            ),
            Question(
                "Pakistan gained independence from British rule in 1947.",
                true
            ),
            Question(
                "Karachi is the capital city of Pakistan.",
                false
            ),
            Question(
                "Lahore is the cultural capital of Pakistan.",
                true
            ),
            Question(
                "The highest mountain peak in Pakistan is K2.",
                true
            ),
            Question(
                "The national flower of Pakistan is Jasmine.",
                true
            ),
            Question(
                "Pakistan shares its border with China, Iran, and Afghanistan.",
                true
            ),
            Question(
                "Islamabad is the largest city in Pakistan by population.",
                false
            ),
            Question(
                "The national sport of Pakistan is hockey.",
                true
            )
        )



        //Question No Currently.
        val questionIndex : TextView = findViewById(R.id.questionIndex)

        // Question No.
        var questionNumber:Int = 10

        // SELECTED Radio Button.
        var selectedRadioButton:RadioButton

        //Radio Buttons
        val radiobtns : RadioGroup = findViewById(R.id.radiogroup1)
        // SELECTED OPTION
        var selectedOptionText: Boolean? = null

        //Button For Submission.
        val submitt:Button=findViewById(R.id.submit_button)

        //Question Text
        val questiontext:TextView = findViewById(R.id.question_textview)

        // Score
        var score:Int=0

        questionIndex.text = "${questionNumber}/10"
        questiontext.text = questions[questionNumber-1].questionText


        radiobtns.setOnCheckedChangeListener { _, checkedId ->
            selectedRadioButton= findViewById(checkedId)
            if(selectedRadioButton.text.toString() == "true"){
                selectedOptionText = true
            }else{
                selectedOptionText = false
            }
        }
        submitt.setOnClickListener {

            if(questionNumber<=10){
                if (selectedOptionText == null){
                    Toast.makeText(this, "Select Option", Toast.LENGTH_SHORT).show()
                }else{
                    if(selectedOptionText == questions[questionNumber-1].correctAnswer){
                        score += 1
                        questionNumber+=1

                        questionIndex.text = "${questionNumber}/10"
                        questiontext.text = questions[questionNumber-1].questionText
                        return@setOnClickListener

                    }
                    else{
                        questionNumber+=1

                        questionIndex.text = "${questionNumber}/10"
                        questiontext.text = questions[questionNumber-1].questionText
                    }
                }
            }else{
             /*   val text: TextView = findViewById(R.id.textView2)
                text.text = "$score"
                finish()*/
            }

        }
    }
}