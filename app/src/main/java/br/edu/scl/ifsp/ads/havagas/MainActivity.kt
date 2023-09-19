package br.edu.scl.ifsp.ads.havagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import br.edu.scl.ifsp.ads.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding

    //Declaração dos componentes
    private lateinit var editTextFullName: EditText
    private lateinit var ckAdicionarCelular : CheckBox
    private lateinit var editTextCelular: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        //Instanciação dos componentes
        editTextFullName = amb.editTextFullName
        ckAdicionarCelular = amb.ckAdicionarCelular
        editTextCelular = amb.editTextCelular

        val buttonSave: Button = amb.buttonSave
        buttonSave.setOnClickListener { saveForm() }

        val buttonClear = amb.buttonClear
        buttonClear.setOnClickListener { clearForm() }

        //Método para exibir ou não o editText do celular
        ckAdicionarCelular.setOnCheckedChangeListener {_,isChecked ->
            if(isChecked){
                editTextCelular.visibility = View.VISIBLE
            } else{
                editTextCelular.visibility = View.GONE
            }
        }
    }

    //função para "salvar" os dados e exibir no popup
    private fun saveForm(){
        val fullName = editTextFullName.text.toString()

        val dados = "Nome completo: $fullName\n"

        //Exibição dos dados no popup
        Toast.makeText(this,dados,Toast.LENGTH_LONG).show()

    }

    private fun clearForm(){
        editTextFullName.text.clear()

    }
}