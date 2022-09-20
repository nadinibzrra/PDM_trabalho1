package ufrn.eaj.supercalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    var variavelX:Int = 0
    var variavelY:Int = 0
    var resultado:Int = 0

    val setVariavelXlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
            if(result.resultCode == RESULT_OK){
                variavelX = result.data!!.getIntExtra("VALOR", 0)
                val textViewX:TextView = findViewById(R.id.textViewX)
                textViewX.text = "${variavelX}"
            }else{
                Toast.makeText(this, getString(R.string.cancelado), Toast.LENGTH_SHORT).show()
            }
    }
    val setVariavelYlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
                if(result.resultCode == RESULT_OK){
                    variavelY = result.data!!.getIntExtra("VALOR", 0)
                    val textViewY:TextView = findViewById(R.id.textViewY)
                    textViewY.text = "${variavelY}"
                }else{
                    Toast.makeText(this, getString(R.string.cancelado), Toast.LENGTH_SHORT).show()
                }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewX:TextView = findViewById(R.id.textViewX)
        val textViewY:TextView = findViewById(R.id.textViewY)
        val textViewResultado:TextView = findViewById(R.id.textViewResultado)

        textViewX.text = "${variavelX}"
        textViewY.text = "${variavelY}"
        textViewResultado.text = "${resultado}"

        val btnVariavelX:TextView = findViewById(R.id.btnVariavelX)
        val btnVariavelY:TextView = findViewById(R.id.btnVariavelY)
        val btnCalcular:TextView = findViewById(R.id.btnCalcular)

        btnVariavelX.setOnClickListener {
            val intent = Intent(this, RecebeActivity::class.java)
            val bundle = Bundle()
            bundle.putString("LABEL",getString(R.string.variavel_x))
            bundle.putInt("VALOR",variavelX)
            intent.putExtras(bundle)
            setVariavelXlauncher.launch(intent)
        }
        btnVariavelY.setOnClickListener {
            val intent = Intent(this, RecebeActivity::class.java)
            val bundle = Bundle()
            bundle.putString("LABEL",getString(R.string.variavel_y))
            bundle.putInt("VALOR",variavelY)
            intent.putExtras(bundle)
            setVariavelYlauncher.launch(intent)
        }
        btnCalcular.setOnClickListener {
            resultado = variavelX + variavelY
            textViewResultado.text = resultado.toString()
            Toast.makeText(this, getString(R.string.realizando_calculos), Toast.LENGTH_SHORT).show()
        }
    }
}