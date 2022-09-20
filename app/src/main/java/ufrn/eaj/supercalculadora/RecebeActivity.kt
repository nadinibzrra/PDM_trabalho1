package ufrn.eaj.supercalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RecebeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recebe)

        var label = intent.extras?.getString("LABEL")
        var valor = intent.extras?.getInt("VALOR")

        val labelVariavel:TextView = findViewById(R.id.labelVariavel)
        val inputNumber:EditText = findViewById(R.id.inputNumber)

        labelVariavel.text = label
        inputNumber.setText(valor.toString())

        val btnOK:Button = findViewById(R.id.btnOK)
        val btnCancelar:Button = findViewById(R.id.btnCancelar)

        btnOK.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putInt("VALOR", inputNumber.text.toString().toInt())
            intent.putExtras(bundle)
            //startActivity(intent)
            setResult(RESULT_OK, intent)
            finish()

        }
        btnCancelar.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}