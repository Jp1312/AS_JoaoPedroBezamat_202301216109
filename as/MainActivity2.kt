package com.example.`as`
import Question
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var textViewQuestion: TextView
    private lateinit var radioGroupOptions: RadioGroup
    private lateinit var radioButtonOption1: RadioButton
    private lateinit var radioButtonOption2: RadioButton
    private lateinit var radioButtonOption3: RadioButton
    private lateinit var radioButtonOption4: RadioButton
    private lateinit var buttonNext: Button

    private val questions = listOf(
        Question(
            "Qual é o planeta mais próximo do Sol?",
            listOf("Vênus", "Mercúrio", "Terra", "Marte"),
            1 // Índice da resposta correta (Mercúrio)
        ),
        Question(
            "Qual é o maior planeta do sistema solar?",
            listOf("Júpiter", "Saturno", "Urano", "Netuno"),
            0 // Índice da resposta correta (Júpiter)
        )
    )

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textViewQuestion = findViewById(R.id.textViewQuestion)
        radioGroupOptions = findViewById(R.id.radioGroupOptions)
        radioButtonOption1 = findViewById(R.id.radioButtonOption1)
        radioButtonOption2 = findViewById(R.id.radioButtonOption2)
        radioButtonOption3 = findViewById(R.id.radioButtonOption3)
        radioButtonOption4 = findViewById(R.id.radioButtonOption4)
        buttonNext = findViewById(R.id.buttonNext)

        showQuestion()

        buttonNext.setOnClickListener {
            val selectedOptionIndex = radioGroupOptions.checkedRadioButtonId
            if (selectedOptionIndex != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedOptionIndex)
                val answerIndex = radioGroupOptions.indexOfChild(selectedRadioButton)

                if (answerIndex == questions[currentQuestionIndex].correctAnswerIndex) {
                    score++
                }

                currentQuestionIndex++
                if (currentQuestionIndex < questions.size) {
                    showQuestion()
                } else {
                    // Se não houver mais perguntas, inicia MainActivity3 com a pontuação atual
                    val intent = Intent(this, MainActivity3::class.java)
                    intent.putExtra("SCORE", score)
                    startActivity(intent)
                    finish()  // Finaliza MainActivity2
                }

                radioGroupOptions.clearCheck()
            }
        }
    }

    private fun showQuestion() {
        val question = questions[currentQuestionIndex]
        textViewQuestion.text = question.text
        radioButtonOption1.text = question.options[0]
        radioButtonOption2.text = question.options[1]
        radioButtonOption3.text = question.options[2]
        radioButtonOption4.text = question.options[3]

        // Habilita os RadioButtons para a próxima pergunta
        radioButtonOption1.isEnabled = true
        radioButtonOption2.isEnabled = true
        radioButtonOption3.isEnabled = true
        radioButtonOption4.isEnabled = true
        buttonNext.isEnabled = true
    }
}
