package com.nogas.mindsetcookies

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.nogas.mindsetcookies.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarie = intent.getStringExtra("INTENT_USUARIE")

        val sharedPrefs = getSharedPreferences(
                "cadastro_$usuarie",
                Context.MODE_PRIVATE
        )

        val nome = sharedPrefs.getString("NOME", "")
        binding.txvMainNomeCompleto.text = "$nome"

        val data = Calendar.getInstance().time
        var dateTimeFormat = SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault())

        binding.txvMainData.text = dateTimeFormat.format(data)

        binding.btnMainAtualizar.setOnClickListener {
            val perfilPrefs = sharedPrefs.getString("PERFIL", "")

            if (perfilPrefs == "EMPREENDEDORE") {
                val listaFrases = arrayListOf("O ativo mais importante que temos é a nossa mente. Se você é bem treinado, você pode criar grandes quantidades de riqueza no que parece ser um instante.",
                        "Se você é focado na competição, você terá que esperar até que um competidor faça algo. Se você é focado nos clientes, poderá ser pioneiro",
                        "Enquanto alguns lamentam a crise, outros aproveitam as oportunidades e enriquecem",
                        "Cuidado com gente que não tem dúvida. Gente que não tem dúvida não é capaz de inovar, de reinventar, não é capaz de fazer de outro modo. Gente que não tem dúvida só é capaz de repetir.",
                        "100% dos clientes são pessoas. 100% dos funcionários são pessoas. Se você não entende de pessoas, você não entende de negócios.",
                        "Creio que o segredo para o sucesso esteja em saber lutar por um grande objetivo e em fracassar bem, isto é, ser capaz de experimentar fracassos dolorosos – fonte de grande aprendizado –, mas não um fracasso grande o suficiente para tirá-lo do jogo.",
                        "Quando as pessoas acreditam que suas qualidades básicas podem ser desenvolvidas, os fracassos podem ser dolorosos, mas não as definem.",
                        "Cada adversidade, cada fracasso, cada dor de cabeça carrega consigo a semente de um benefício igual ou maior.",
                        "Tudo na vida que valha a pena ter, vale a pena trabalhar para ter.",
                        "Se você precisa de um herói para fazer as coisas, você tem um problema. O esforço heróico deve ser visto como uma falha de planejamento.")
                val listaAutores = arrayListOf("Robert Kiyosaki", "Jeff Bezos", "Gustavo Cerbasi", "Mario Sergio Cortella", "Simon Sinek", "Ray Dalio", "Carol S. Dweck",
                        "Napoleon Hill", "Andrew Carnegie", "Jeff Sutherland")
                var x = Random.nextInt(0, 9)
                var frase = findViewById<View>(R.id.txvMainFrase) as TextView
                var autor = findViewById<View>(R.id.txvMainAutor) as TextView
                frase.setText(listaFrases[x])
                autor.setText(listaAutores[x])
            } else if (perfilPrefs == "CREATIVE") {
                val listaFrases = arrayListOf("Ninguém nasce com um estilo ou uma voz. Não saímos do útero sabendo quem somos. No início, aprendemos fingindo ser nossos heróis. Nós aprendemos copiando.",
                        "A simplicidade é o último grau de sofisticação.",
                        "As emoções mudam a maneira como a mente humana soluciona problemas.",
                        "A vida é vivida em perfeita simetria, o que eu fizer também será feito para mim.",
                        "Uma marca é a intuição que uma pessoa tem sobre um produto, serviço ou empresa. A marca não é aquilo que voce diz que é. É aquilo que eles dizem que é.",
                        "Fomos crinaças sem pais... então encontramos nossos pais nos discos, nas ruas e na história. Tivemos que pegar e escolher nossos ancestrais que inspirariam o mundo que construiriamos para nós mesmos.",
                        "O trabalho que você faz enquanto fica enrolando é provavelmente o trabalho que você deveria estar fazendo para o resto da sua vida.",
                        "Não dá para ligar os pontos olhando para frente, você os liga olhando para trás", "Criatividade não é um talento, é uma forma de operar.",
                        "Isso é o que todos nós somos: amadores. Não vivemos o suficiente para nos tornarmos outra coisa.")
                val listaAutores = arrayListOf("Austin Kleon", "Leonardo Da Vinci", "Donald A. Norman", "Keane - Perfect Simmetry", "Marty Neumeier, the Brand Gap",
                        "Jay-Z", "Jessica Hische", "Steve Jobs", "John Cleese", "Charlie Chaplin")
                var x = Random.nextInt(0, 9)
                var frase = findViewById<View>(R.id.txvMainFrase) as TextView
                var autor = findViewById<View>(R.id.txvMainAutor) as TextView
                frase.setText(listaFrases[x])
                autor.setText(listaAutores[x])
            } else if (perfilPrefs == "GEEK") {
                val listaFrases = arrayListOf("Posso não ter crescido nem um centímetro, mas não vou deixar que o meu coração fique pequeno para sempre!",
                        "As pessoas fortes não derrubam as outras, elas ajudam-nas a se erguerem.",
                        "Há momentos que você precisa desistir de alguma coisa para preservar a outra.",
                        "Mesmo que individualmente cada uma das nossas vidas seja pequena, todos nós fazemos parte do universo. Se entendermos isso, se sentirmos, se deixarmos queimar dentro de nós, a vida pode brilhar!",
                        "Só aqueles que desistiram de viver acham que os sonhos são impossíveis.",
                        "Não importa o quanto tenha medo, deve sorrir para mostrar que está tudo bem. Neste mundo, aqueles que sorriem são os mais fortes!",
                        "As circunstâncias do nascimento de alguém são irrelevantes. É o que você faz com o dom da vida que determina quem você é.",
                        "Não importa o que o mundo diz de mim, o que importa é que eu nunca fiz nada que contrariasse os meus princípios e nunca farei.",
                        "A verdadeira batalha começa quando as forças estão chegando ao fim.",
                        "Nenhum ser humano na sociedade deveria ser considerado menos valioso que os outros.")
                val listaAutores = arrayListOf("Edward, FullMetal Alchemist", "Goku, Dragon Ball Z", "Rize, Tokyo Ghoul", "Sage de Cancer, The Lost Canvas",
                        "Hyoga de Cisne, Os Cavaleiros do Zodíaco", "Shimura Nana, Boku no Hero Academia", "Mewtwo, Pokemon",
                        "Zoro, One Piece", "Mestra Genkai, Yu Yu Hakusho", "Kenshin, Samurai X")
                var x = Random.nextInt(0, 9)
                var frase = findViewById<View>(R.id.txvMainFrase) as TextView
                var autor = findViewById<View>(R.id.txvMainAutor) as TextView
                frase.setText(listaFrases[x])
                autor.setText(listaAutores[x])
            }
        }

        binding.txvMainSair.setOnClickListener {
            val alert = AlertDialog.Builder(this)

            alert.setTitle("Atenção!")
            alert.setMessage("Deseja mesmo sair?")
            alert.setPositiveButton("Sair") {
                dialog, which ->  val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)
                finishAffinity()
            }
            alert.setNeutralButton("Não") {
                dialog, which ->
            }
            alert.setCancelable(false)
            alert.show()
        }
    }
}
