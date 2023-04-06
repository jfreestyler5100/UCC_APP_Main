package com.example.uccapp

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi

class activity_social : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social)
        val web: WebView = findViewById(R.id.wvSocial)
        web.webViewClient = CustomWebViewClient(this)
        when(intent.getStringExtra("code")){
            "facebook" ->  web.loadUrl("https://www.facebook.com/uccjamaica")
            "instagram" ->  web.loadUrl("https://www.instagram.com/uccjamaica")
            "twitter" -> web.loadUrl("http://www.twitter.com/uccjamaica")
        }
        val webSettings = web.settings
        webSettings.javaScriptEnabled =true
    }
    //Allows external website to load within WebView element
    class CustomWebViewClient internal constructor(private val activity: Activity) :
        WebViewClient() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            val url: String = request?.url.toString();
            view?.loadUrl(url)
            return true
        }

        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }

        override fun onReceivedError(
            view: WebView,
            request: WebResourceRequest,
            error: WebResourceError
        ) {
            Toast.makeText(activity, "Error! $error", Toast.LENGTH_SHORT).show()
        }
    }
}