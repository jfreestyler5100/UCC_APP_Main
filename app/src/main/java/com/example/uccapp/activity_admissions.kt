package com.example.uccapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class activity_admissions : AppCompatActivity() {
    private val url: String = "https://ucc.edu.jm/apply/" //variable used to store the url for ucc admissions
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)
    val admissions: ImageView = findViewById(R.id.adAppLnk)

        //Launch the device browser and load UCC Application page
        admissions.setOnClickListener{

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent) //Start external browser with the url for UCC admissions
        }
    }
}