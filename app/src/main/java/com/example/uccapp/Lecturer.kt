package com.example.uccapp

data class Lecturer (val email: String? = null, val name: String?= null, val department: String?= null, val phone: String?=null,
                    val image: String?=null) {
    // Null default values create a no argument default constructor, which is needed
    //for deserialization from a DataSnapshot
}
