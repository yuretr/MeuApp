package br.com.meuapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SendResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_result)

        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btCancel = findViewById<Button>(R.id.btCancel)
//      ctrl + D, duplica a linha abaixo

        btYes.setOnClickListener {
            val intent = Intent()

            intent.putExtra("RESULT", getString(R.string.sim))

            setResult(Activity.RESULT_OK, intent)
//          aqui recebe a informação de sim

            finish()
        }

        btNo.setOnClickListener {
            val intent = Intent()

            intent.putExtra("RESULT", getString(R.string.n_o))

            setResult(Activity.RESULT_OK, intent)
//          aqui recebe a informação de não

            finish()
        }

        btCancel.setOnClickListener {

            setResult(Activity.RESULT_CANCELED)

            finish()
        }
    }
}