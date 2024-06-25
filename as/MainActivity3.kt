package com.example.`as`

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        buttonNext = findViewById(R.id.buttonNext) //

        buttonNext.setOnClickListener {

            val intent = Intent(this, EndActivity::class.java)
            val score = intent.getIntExtra("SCORE", 0)
            intent.putExtra("SCORE", score)
            startActivity(intent)
        }
    }
}
