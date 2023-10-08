package br.com.meuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val nomeDigitado = intent.getStringExtra("NOME_DIGITADO")
//      se foi aberta por uma outra tela, então já tem uma intent
//      "NOME_DIGITADO" traz a informação guardada da outra tela

        val tvResultado2 = findViewById<TextView>(R.id.tvResultado2)

        tvResultado2.text = nomeDigitado
    }
}