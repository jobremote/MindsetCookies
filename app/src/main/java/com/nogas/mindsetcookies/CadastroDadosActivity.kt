package com.nogas.mindsetcookies

import android.R
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.nogas.mindsetcookies.databinding.ActivityCadastroDadosBinding

class CadastroDadosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroDadosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaGenero = arrayListOf("Gênero", "Masculino", "Feminino", "Transgênero", "Não-Binário", "Outros", "Prefiro não declarar")
        val spinnerAdapter = ArrayAdapter (
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listaGenero
        )

        binding.spnCadastroGenero.adapter = spinnerAdapter

        binding.btnCadastroAvancar.setOnClickListener {
            val nome = binding.edtCadastroNome.text.toString().trim()
            val usuarie = binding.edtCadastroUsuarie.text.toString().trim()
            val email = binding.edtCadastroEmail.text.toString().trim()
            val senha = binding.edtCadastroSenha.text.toString().trim()
            val genero = binding.spnCadastroGenero.selectedItem.toString()

            if (nome.isEmpty() ||
                usuarie.isEmpty() ||
                email.isEmpty() ||
                senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else if (genero == listaGenero[0]) {
                Toast.makeText(this, "Escolha uma opção de gênero", Toast.LENGTH_LONG).show()
            } else {
                val sharedPrefs = getSharedPreferences(
                    "cadastro_$usuarie",
                    Context.MODE_PRIVATE
                )
                val editPrefs = sharedPrefs.edit()
                editPrefs.putString("NOME", nome)
                editPrefs.putString("USUARIE", usuarie)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("GENERO", genero)

                editPrefs.apply()

                val mIntent = Intent(this, CadastroPerfilActivity::class.java)

                mIntent.putExtra("INTENT_USUARIE", usuarie)
                startActivity(mIntent)

                finishAffinity()
            }
        }

        binding.iconCadastroVoltar.setOnClickListener {
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}