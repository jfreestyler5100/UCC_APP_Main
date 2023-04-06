package com.example.uccapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //declaration of variables an assigning them to objects from the activity
        val faculty: ImageView = findViewById(R.id.mnFaculty)
        val courses: ImageView = findViewById(R.id.mnCourses)
        val facebook: ImageView = findViewById(R.id.mnFacebook)
        val instagram: ImageView = findViewById(R.id.mnInstagram)
        val twitter: ImageView = findViewById(R.id.mnTwitter)
        val admissions: ImageView = findViewById(R.id.mnAdmissions)

        //Action to perform when user clicks the faculty icon
        faculty.setOnClickListener{
            val intent = Intent(this, activity_faculty::class.java)
            startActivity(intent) //start the faculty activity
        }

        //Action to perform when user clicks the courses icon
        courses.setOnClickListener{
            val intent = Intent(this, activity_courseslist::class.java)
            startActivity(intent) //start the courses list activity
        }

        //Action to perform when user clicks the facebook icon
        facebook.setOnClickListener{
            val intent = Intent(this, activity_social::class.java)
            intent.putExtra("code", "facebook") //pass identified to the in app browser activity
            startActivity(intent) //start in app browser activity
        }

        //Action to perform when user click the instagram icon
        instagram.setOnClickListener{
            val intent = Intent(this, activity_social::class.java)
            intent.putExtra("code", "instagram")
            startActivity(intent)//start in app browser activity
        }

        //Action to perform when user click the twitter icon
        twitter.setOnClickListener{
            val intent = Intent(this, activity_social::class.java)
            intent.putExtra("code", "twitter")
            startActivity(intent) //start in app browser activity
        }

        //Sends email to preset address when FAB is clicked
        val sendEmail: FloatingActionButton = findViewById(R.id.mnEmail)
        sendEmail.setOnClickListener {
            val mail: String = "ucconline@ucc.edu.jm"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", mail, null))
            intent.putExtra(Intent.EXTRA_EMAIL, mail)
            startActivity(intent) //start intent to open external email app
        }
        //Start admissions activity on button click
        admissions.setOnClickListener{
            val intent = Intent(this, activity_admissions::class.java)
            startActivity(intent) //start the admissions activity
        }
    }

}