package br.com.meuapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.annotation.StringRes
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
            sendResult(R.string.sim)
        }

        btNo.setOnClickListener {
            sendResult(R.string.n_o)
        }

        btCancel.setOnClickListener {

            setResult(Activity.RESULT_CANCELED)

            finish()
        }
    }


    private fun sendResult(@StringRes stringResId: Int) {
//          @StringRes faz com que a informação não seja qualquer inteiro, e sim uma string
        val intent = Intent()

        intent.putExtra("RESULT", getString(stringResId))

        setResult(Activity.RESULT_OK, intent)
        //          aqui recebe a informação de sim ou não

        finish()
    }
}