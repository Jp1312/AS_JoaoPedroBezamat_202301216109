package com.example.`as`

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.`as`.R


class EndActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        val textViewScore = findViewById<TextView>(R.id.textViewScore)
        val textViewScoreValue = findViewById<TextView>(R.id.textViewScoreValue)
        val buttonShare = findViewById<Button>(R.id.buttonShare)

        // Recebe a pontuação da MainActivity2 ou MainActivity3
        val score = intent.getIntExtra("SCORE", 0)
        textViewScoreValue.text = "$score / 2"  // Supondo que há 2 perguntas no total

        // Configuração do botão para compartilhar
        buttonShare.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Minha pontuação final foi: $score de 2 perguntas no quiz do sistema solar!")
            }
            startActivity(Intent.createChooser(shareIntent, "Compartilhar pontuação via"))
        }
    }
}
