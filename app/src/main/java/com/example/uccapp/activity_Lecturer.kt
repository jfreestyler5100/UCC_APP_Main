package com.example.uccapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat

class activity_Lecturer : AppCompatActivity() {
    //Declare variables for instances to be later initialised for each object on the activity
    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvDepartment: TextView
    private lateinit var imImage: ImageView
    private lateinit var tvPhone: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecturer)
        initView()
        setValuesToViews()
    }
    //function used to initialize variables
    private fun initView(){

        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvDepartment = findViewById(R.id.tvDepartment)
        imImage = findViewById(R.id.imLecturer)
        tvPhone = findViewById(R.id.tvPhone)

    }
    //function used to set the values to be displayed to the user
    private fun setValuesToViews(){
        //when statement is used to select the correct image for the lecturer
        when(intent.getStringExtra("image")){

            "rose" -> imImage.setImageResource(R.drawable.rose)
            "amonde" -> imImage.setImageResource(R.drawable.amonde)
            "miller" -> imImage.setImageResource(R.drawable.miller)
            "ndajah"-> imImage.setImageResource(R.drawable.ndajah)
            "davidson" ->imImage.setImageResource(R.drawable.davidson)

        }
        //retrieving values from intent and displaying it to user
        tvName.text = intent.getStringExtra("name")
        tvEmail.text = intent.getStringExtra("email")
        tvDepartment.text = intent.getStringExtra("department")
        tvPhone.text = intent.getStringExtra("phone")

        //Send email to staff if email is clicked
        tvEmail.setOnClickListener{
            val mail: String = intent.getStringExtra("email").toString() //assign email address to variable
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", mail, null))
            intent.putExtra(Intent.EXTRA_EMAIL, mail) //pass email to intent
            startActivity(intent)
        }
        //Call phone number if clicked
        tvPhone.setOnClickListener{
            checkPermission()  //call function to check permission
            val number = intent.getStringExtra("phone") //assign phone number to a variable
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$number") //pass number to intent
            startActivity(intent)
        }
    }
    //function to check if permission has been granted to make phone calls from app
    private fun checkPermission(){
        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 101)
        }
    }
}