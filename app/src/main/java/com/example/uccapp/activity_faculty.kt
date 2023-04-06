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

class activity_faculty : AppCompatActivity() {
    private var db = Firebase.firestore //global instance of the firebase database object
    private lateinit var facultyList: ArrayList<Lecturer> //initialise global array for storing lecturer details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty)

        //variable link to the recyclerview element on the activity
        var rvFaculty: RecyclerView = findViewById(R.id.rvFaculty)
        rvFaculty.layoutManager = LinearLayoutManager(this)

        facultyList = arrayListOf()
        getAllDocs(rvFaculty) //call function and pass in the recyclerview object.

    }
    //function used to retrieve data from firestorm and populate the recyclerview
    private fun getAllDocs(rvFaculty: RecyclerView) {
        // [START get_multiple_all]
        db = FirebaseFirestore.getInstance()
         db.collection("Lecturer")
            .get()
            .addOnSuccessListener {
                if(!it.isEmpty){
                     for (data in it.documents) {
                        val lecturers: Lecturer? = data.toObject(Lecturer::class.java)
                         if(lecturers != null){
                            facultyList.add(lecturers)
                         }
                     }
                        val mAdapter = MyAdapter(facultyList)
                        rvFaculty.adapter = mAdapter
                        mAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
                            override fun onItemClick(position: Int) {
                                val intent = Intent(this@activity_faculty, activity_Lecturer::class.java)
                                //put extras
                                intent.putExtra("name", facultyList[position].name)
                                intent.putExtra("email", facultyList[position].email)
                                intent.putExtra("department", facultyList[position].department)
                                intent.putExtra("phone", facultyList[position].phone)
                                intent.putExtra("image", facultyList[position].image)
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