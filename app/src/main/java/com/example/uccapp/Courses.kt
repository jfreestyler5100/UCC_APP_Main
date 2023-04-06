package com.example.uccapp

data class Courses(val code: String? = null, val title: String?= null, val credits: Int?= null, val pre: String?= null, val desc: String?= null) {
    // Null default values create a no argument default constructor, which is needed
    //for deserialization from a DataSnapshot
}