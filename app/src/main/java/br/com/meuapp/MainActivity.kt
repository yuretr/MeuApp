package br.com.meuapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etNome = findViewById<TextView>(R.id.etNome)
        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val btEnviar2 = findViewById<Button>(R.id.btEnviar2)
        val btEnviar3 = findViewById<Button>(R.id.btEnviar3)
//
//      O aplicativo mostra o nome inserido pelo usuário junto a mensagem de recepcão "Ola, seja bem vindo".
//      Está disponível em nos idiomas Português-br e Inglês.
//
        btEnviar.setOnClickListener {
            if (etNome.text.isNotBlank()) {
//          isNotBlack() verifica se não está em branco, ou somente com espaços, se tiver o nome ele segue o código
                tvResultado.text = getString(R.string.ola_nome, etNome.text.toString())
//              etNome.text é editable, a escrita pode sofrer modificações, para evitar isso coloquei etNome.text.toString(), assim transforma em string e não sofre possíveis alterações
//              getString(R.string.ola_nome) puxa o caminho de uma String salva
//              etNome.text.toString puxa o nome digitado no campo
            } else {
                etNome.error = getString(R.string.digite_seu_nome)
//              aqui deixamos uma condição, caso não seja digitado nenhum nome aparece a mensagem "Digite seu nome"
            }
        }

        btEnviar2.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                val nomeDigitado = etNome.text.toString()
                val intent = Intent(this, ResultActivity::class.java)

                intent.putExtra("NOME_DIGITADO", nomeDigitado)
//              intent.putextra passa a informação para a outra tela

                startActivity(intent)
            } else {
                etNome.error = getString(R.string.digite_seu_nome)
            }
        }

        btEnviar3.setOnClickListener {

            val intent = Intent(this, SendResultActivity::class.java)

//            val requestCode = 1

            getResult.launch(intent)
//            startActivityForResult(intent, requestCode)

//            startActivity(intent)

//          CTRL + ALT + L = Ajusta formatação do código

        }
    }


    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {

            if (it.resultCode == Activity.RESULT_OK) {
                val result = it.data?.getStringExtra("RESULT")
                val tvResultado = findViewById<TextView>(R.id.tvResultado)
                tvResultado.text = getString(R.string.informa_o_recebida_1s, result)

            } else if (it.resultCode == Activity.RESULT_CANCELED) {
                val tvResultado = findViewById<TextView>(R.id.tvResultado)
                tvResultado.text = getString(R.string.tela_foi_cancelada)
            }
        }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == 1) {
//            if (resultCode == Activity.RESULT_OK && data != null) {
////            data é null, se for diferente de null entra no código (!=)
//                val result = data.getStringExtra("RESULT")
//
//                val tvResultado = findViewById<TextView>(R.id.tvResultado)
//                tvResultado.text = getString(R.string.informa_o_recebida_1s, result)
//
//
//            } else if (resultCode == Activity.RESULT_CANCELED) {
//                val tvResultado = findViewById<TextView>(R.id.tvResultado)
//                tvResultado.text = getString(R.string.tela_foi_cancelada)
//            }
//        }
//    }
}