package com.nogas.mindsetcookies

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nogas.mindsetcookies.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityLoginBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginLogin.setOnClickListener {
            val usuarie = binding.edtLoginUsuarie.text.toString().trim()
            val senha = binding.edtLoginSenha.text.toString().trim()

            if (usuarie.isEmpty()) {
                binding.edtLoginUsuarie.error = "Campo obrigatório"
                binding.edtLoginUsuarie.requestFocus()
            } else if (senha.isEmpty()) {
                binding.edtLoginSenha.error = "Campo obrigatório"
                binding.edtLoginSenha.requestFocus()
            } else {
                val sharedPrefs = getSharedPreferences(
                    "cadastro_$usuarie",
                    Context.MODE_PRIVATE
                )
                val usuariePrefs = sharedPrefs.getString("USUARIE", "")
                val senhaPrefs = sharedPrefs.getString("SENHA", "")

                if (usuarie == usuariePrefs && senha == senhaPrefs) {
                    Toast.makeText(this, "Usuárie logado com sucesso", Toast.LENGTH_LONG).show()
                    val mIntent = Intent(this, MainActivity::class.java)
                    mIntent.putExtra("INTENT_USUARIE", usuarie)
                    startActivity(mIntent)
                    finish()
                } else {
                    Toast.makeText(this, "Usuárie ou senha inválidos", Toast.LENGTH_LONG).show()
                }
            }


        }

        binding.btnLoginCadastro.setOnClickListener{
            val mIntent = Intent(this, CadastroDadosActivity::class.java)
            startActivity(mIntent)
            finish()
        }

        binding.btnLoginSite.setOnClickListener {
            val mIntent2 = Intent(this, WebActivity::class.java)
            startActivity(mIntent2)
        }

        binding.txvCadastroCadastro.setOnClickListener {
            val mIntent = Intent(this, CadastroDadosActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}