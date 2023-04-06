package com.example.uccapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class activity_courseslist : AppCompatActivity() {
    private var db = Firebase.firestore
    private lateinit var courseList: ArrayList<Courses>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courseslist)
        var rvCourses: RecyclerView = findViewById(R.id.rvCourses)
        rvCourses.layoutManager = LinearLayoutManager(this)

        courseList = arrayListOf()
        getAllDocs(rvCourses)
    }
    private fun getAllDocs(rvCourses: RecyclerView) {
        // [START get_multiple_all]
        db = FirebaseFirestore.getInstance()
        db.collection("Courses")
            .get()
            .addOnSuccessListener {
                if(!it.isEmpty){
                    for (data in it.documents) {
                        val courses: Courses? = data.toObject(Courses::class.java)
                        if(courses != null){
                            courseList.add(courses)
                        }
                    }
                    val mAdapter = MyAdapterCourses(courseList)
                    rvCourses.adapter = mAdapter
                    mAdapter.setOnItemClickListener(object : MyAdapterCourses.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@activity_courseslist, activity_courses::class.java)
                            //put extras
                            intent.putExtra("code", courseList[position].code)
                            intent.putExtra("title", courseList[position].title)
                            intent.putExtra("credits", courseList[position].credits.toString())
                            intent.putExtra("pre", courseList[position].pre)
                            intent.putExtra("desc", courseList[position].desc)
                            startActivity(intent)
                        }
                    })
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()

            }
    }
}