package com.example.newsapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class DetailActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val mywebview = findViewById<WebView>(R.id.webView)
        val myprogressbar = findViewById<ProgressBar>(R.id.progressBar)
        val url = intent.getStringExtra("URL")
        if(url != null)
        {
            mywebview.settings.javaScriptEnabled = true
            mywebview.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    myprogressbar.visibility = View.GONE
                    mywebview.visibility = View.VISIBLE

                }
            }
            mywebview.loadUrl(url)
        }
    }
}