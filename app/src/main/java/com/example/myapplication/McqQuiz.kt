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

class McqQuiz:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mcqquiz_activity)
        data class Question(
            val questionText: String,
            val options: List<String>,
            val correctAnswer: String
        )
        val questions: List<Question> = listOf(
            Question(
                "What does HTML stand for?",
                listOf("Hyper Text Markup Language", "Hyperlinks and Text Markup Language", "Home Tool Markup Language", "Hyper Transfer Markup Language"),
                "Hyper Text Markup Language"
            ),
            Question(
                "Which of the following is a programming language?",
                listOf("XML", "HTML", "Python", "CSS"),
                "Python"
            ),
            Question(
                "What does CSS stand for?",
                listOf("Cascading Style Sheets", "Computer Style Sheets", "Creative Style Sheets", "Colorful Style Sheets"),
                "Cascading Style Sheets"
            ),
            Question(
                "Which of the following is not a data type in Python?",
                listOf("int", "str", "char", "float"),
                "char"
            ),
            Question(
                "What does SQL stand for?",
                listOf("Structured Query Language", "Sequential Query Language", "Standardized Query Language", "Software Query Language"),
                "Structured Query Language"
            ),
            Question(
                "What does IDE stand for?",
                listOf("Integrated Development Environment", "Integrated Design Environment", "Interactive Development Environment", "Intelligent Development Environment"),
                "Integrated Development Environment"
            ),
            Question(
                "Which programming language is often used for web development?",
                listOf("Java", "C++", "JavaScript", "Swift"),
                "JavaScript"
            ),
            Question(
                "What does JVM stand for?",
                listOf("Java Virtual Machine", "JavaScript Virtual Machine", "Java Visual Machine", "Java Verification Machine"),
                "Java Virtual Machine"
            ),
            Question(
                "What does OOP stand for?",
                listOf("Object-Oriented Programming", "Object-Oriented Protocol", "Object-Oriented Process", "Object-Oriented Project"),
                "Object-Oriented Programming"
            ),
            Question(
                "Which of the following is not a programming paradigm?",
                listOf("Functional Programming", "Object-Oriented Programming", "Procedural Programming", "Logical Programming"),
                "Logical Programming"
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
        val radiobtn1:RadioButton = findViewById(R.id.option1_radio_button)
        val radiobtn2:RadioButton = findViewById(R.id.option2_radio_button)
        val radiobtn3:RadioButton = findViewById(R.id.option3_radio_button)
        val radiobtn4:RadioButton = findViewById(R.id.option4_radio_button)

        // SELECTED OPTION
        var selectedOptionText: String? = null

        //Button For Submission.
        val submitt:Button=findViewById(R.id.submit_button)

        //Question Text
        val questiontext:TextView = findViewById(R.id.question_textview)

        // Score
        var score:Int=0

        questionIndex.text = "${questionNumber}/10"
        questiontext.text = questions[questionNumber-1].questionText
        radiobtn1.text = questions[questionNumber-1].options[0]
        radiobtn2.text =questions[questionNumber-1].options[1]
        radiobtn3.text = questions[questionNumber-1].options[2]
        radiobtn4.text = questions[questionNumber-1].options[3]


        radiobtns.setOnCheckedChangeListener { _, checkedId ->
            selectedRadioButton= findViewById(checkedId)
            selectedOptionText = selectedRadioButton.text.toString()
        }
        submitt.setOnClickListener {

            if(questionNumber<=10){
                if (selectedOptionText == null){
                    Toast.makeText(this, "Select Option", Toast.LENGTH_SHORT).show()
                }else{
                    if(selectedOptionText.toString() == questions[questionNumber-1].correctAnswer){
                        score += 1
                        questionNumber+=1

                        questionIndex.text = "${questionNumber}/10"
                        questiontext.text = questions[questionNumber-1].questionText
                        radiobtn1.text = questions[questionNumber-1].options[0]
                        radiobtn2.text =questions[questionNumber-1].options[1]
                        radiobtn3.text = questions[questionNumber-1].options[2]
                        radiobtn4.text = questions[questionNumber-1].options[3]

                        return@setOnClickListener

                    }
                    else{
                        questionNumber+=1

                        questionIndex.text = "${questionNumber}/10"
                        questiontext.text = questions[questionNumber-1].questionText
                        radiobtn1.text = questions[questionNumber-1].options[0]
                        radiobtn2.text =questions[questionNumber-1].options[1]
                        radiobtn3.text = questions[questionNumber-1].options[2]
                        radiobtn4.text = questions[questionNumber-1].options[3]
                    }
                }
            }else{
                val text: TextView = findViewById(R.id.textView2)
                text.text = "$score"
                finish()
            }
        }
    }
}