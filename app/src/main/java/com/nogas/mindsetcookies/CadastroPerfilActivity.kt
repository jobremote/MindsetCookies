package com.nogas.mindsetcookies

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.nogas.mindsetcookies.databinding.ActivityCadastroPerfilBinding
import kotlin.random.Random
import com.nogas.mindsetcookies.CadastroDadosActivity as MindsetcookiesCadastroDadosActivity

class CadastroPerfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroPerfilBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnCadastroEmpreendedore.setOnClickListener {
            val usuarie = intent.getStringExtra("INTENT_USUARIE")

            val sharedPrefs = getSharedPreferences(
                    "cadastro_$usuarie",
                    Context.MODE_PRIVATE
            )
            val editPrefs = sharedPrefs.edit()
            editPrefs.putString("PERFIL", "EMPREENDEDORE")

            editPrefs.apply()

            val alert = AlertDialog.Builder(this)

            alert.setTitle("Seja bem vindo!")
            alert.setMessage("Cadastro concluído com sucesso. Aproveite!")
            alert.setPositiveButton("Efetuar login") {
                dialog, which ->  val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)
                finishAffinity()
            }
            alert.show()
        }
        binding.btnCadastroCreative.setOnClickListener {
            val usuarie = intent.getStringExtra("INTENT_USUARIE")

            val sharedPrefs = getSharedPreferences(
                    "cadastro_$usuarie",
                    Context.MODE_PRIVATE
            )
            val editPrefs = sharedPrefs.edit()
            editPrefs.putString("PERFIL", "CREATIVE")

            editPrefs.apply()

            val alert = AlertDialog.Builder(this)

            alert.setTitle("Seja bem vindo!")
            alert.setMessage("Cadastro concluído com sucesso. Aproveite!")
            alert.setPositiveButton("Efetuar login") {
                dialog, which ->  val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)
                finishAffinity()
            }
            alert.show()
        }
        binding.btnCadastroGeek.setOnClickListener {
            val usuarie = intent.getStringExtra("INTENT_USUARIE")

            val sharedPrefs = getSharedPreferences(
                    "cadastro_$usuarie",
                    Context.MODE_PRIVATE
            )
            val editPrefs = sharedPrefs.edit()
            editPrefs.putString("PERFIL", "GEEK")

            editPrefs.apply()

            val alert = AlertDialog.Builder(this)

            alert.setTitle("Seja bem vindo!")
            alert.setMessage("Cadastro concluído com sucesso. Aproveite!")
            alert.setPositiveButton("Efetuar login") {
                dialog, which ->  val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)
                finishAffinity()
            }
            alert.show()
        }
    }
}