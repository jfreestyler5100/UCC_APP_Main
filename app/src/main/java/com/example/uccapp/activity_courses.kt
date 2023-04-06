package com.example.uccapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class activity_courses : AppCompatActivity() {
    private lateinit var tvCode: TextView
    private lateinit var tvTitle: TextView
    private lateinit var tvCredits: TextView
    private lateinit var tvPre: TextView
    private lateinit var tvDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        initView()
        setValuesToViews()
    }
    private fun initView(){
        tvCode = findViewById(R.id.tvCode)
        tvTitle = findViewById(R.id.tvTitle)
        tvCredits = findViewById(R.id.tvCredits)
        tvPre = findViewById(R.id.tvPre)
        tvDesc = findViewById(R.id.tvDesc)

    }
    private fun setValuesToViews(){
        tvCode.text = intent.getStringExtra("code")
        tvTitle.text = intent.getStringExtra("title")
        tvCredits.text = intent.getStringExtra("credits")
        tvPre.text = intent.getStringExtra("pre")
        tvDesc.text = intent.getStringExtra("desc")
    }
}