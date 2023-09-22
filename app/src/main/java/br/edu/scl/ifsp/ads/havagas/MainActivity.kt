package br.edu.scl.ifsp.ads.havagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.isVisible
import br.edu.scl.ifsp.ads.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding

    //Declaração dos componentes
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var cbEmail: CheckBox
    private lateinit var stPhone: Switch
    private lateinit var etPhone: EditText
    private lateinit var ckAdicionarCelular : CheckBox
    private lateinit var etCelular: EditText
    private lateinit var etNascimento: EditText
    private lateinit var rgSexo: RadioGroup
    private lateinit var rbMasculino: RadioButton
    private lateinit var rbFeminino: RadioButton
    private lateinit var spFormation: Spinner
    private lateinit var etVagas: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        //Instanciação dos componentes
        etName = amb.editTextFullName
        etEmail = amb.editTextEmail
        cbEmail = amb.checkBoxEmail
        stPhone = amb.switchTelefone
        etPhone = amb.editTextPhone
        ckAdicionarCelular = amb.ckAdicionarCelular
        etCelular = amb.editTextCelular
        etNascimento = amb.editTextNascimento
        rgSexo = amb.radioGroupSexo
        rbMasculino = amb.radioMasculino
        rbFeminino = amb.radioFeminino
        spFormation = amb.spinnerFormacao
        etVagas = amb.editTextVagas

        val buttonSave: Button = amb.buttonSave
        buttonSave.setOnClickListener { saveForm() }

        val buttonClear = amb.buttonClear
        buttonClear.setOnClickListener { clearForm() }

        //Método para exibir ou não o editText do celular
        ckAdicionarCelular.setOnCheckedChangeListener {_,isChecked ->
            if(isChecked){
                etCelular.visibility = View.VISIBLE
            } else{
                etCelular.visibility = View.GONE
            }
        }

    }

    //função para "salvar" os dados e exibir no popup
    private fun saveForm(){
        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val emailPromo = cbEmail.isChecked.toString()
        val phone = etPhone.text.toString()
        val op:String
        val st:String
        val switch = stPhone.isChecked.toString()
        val celular:String
        val sexo: String
        val nascimento = etNascimento.text.toString()
        val formacao = spFormation.selectedItem.toString()
        val vagas = etVagas.text.toString()

        if(ckAdicionarCelular.isChecked === true) { celular = etCelular.text.toString()}else{celular="não informado"}

        if(emailPromo == "true"){op = "sim"}else{op = "não"}
        if(switch == "true"){st = "comercial"}else{st = "residencial"}

        if(rbMasculino.isChecked === true){sexo="masculino"}else{sexo = "feminino"}

        val dados = "Nome completo: $name\n" +
                "Email: $email\n" +
                "Recebe emails promocionais? $op\n" +
                "Telefone: $phone - $st\n" +
                "Celular: $celular\n" +
                "Data de nascimento: $nascimento\n" +
                "Sexo: $sexo\n" +
                "Formação: $formacao\n" +
                "Vagas de interesse: $vagas"

        //Exibição dos dados no Toast
        Toast.makeText(this,dados,Toast.LENGTH_LONG).show()

    }

    private fun clearForm(){
        etName.text.clear()
        etEmail.text.clear()
        cbEmail.isChecked = false
        stPhone.isChecked = false
        etPhone.text.clear()
        ckAdicionarCelular.isChecked = false
        etCelular.text.clear()
        etNascimento.text.clear()
        rbMasculino.isChecked = true
        etVagas.text.clear()
    }
}