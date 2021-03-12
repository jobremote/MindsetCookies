package com.nogas.mindsetcookies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.nogas.mindsetcookies.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.wbvWeb.settings.javaScriptEnabled = true
        binding.wbvWeb.loadUrl("https://github.com/jobremote")
        binding.wbvWeb.webViewClient = WebViewClient()
        binding.iconVoltar.setOnClickListener {
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}