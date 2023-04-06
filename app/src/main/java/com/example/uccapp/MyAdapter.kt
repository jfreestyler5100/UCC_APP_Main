package com.example.uccapp

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val lecturerList: ArrayList<Lecturer>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
        private lateinit var mListener: onItemClickListener

        interface onItemClickListener{
            fun onItemClick(position: Int)
        }
        fun setOnItemClickListener(clickListener: onItemClickListener){
            mListener = clickListener
        }
        class MyViewHolder(itemView: View, clickListener: onItemClickListener): RecyclerView.ViewHolder(itemView){
            val name: TextView = itemView.findViewById(R.id.tvLecturer)
            init{
                itemView.setOnClickListener{
                    clickListener.onItemClick(adapterPosition)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_lecturers, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = lecturerList[position].name
    }

    override fun getItemCount(): Int {
        return lecturerList.size
    }
}
class MyAdapterCourses(private val courseList: ArrayList<Courses>):
    RecyclerView.Adapter<MyAdapterCourses.MyViewHolder>(){
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }
    class MyViewHolder(itemView: View, clickListener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.tvCourses)
        init{
            itemView.setOnClickListener{
                clickListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_courses, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var display = courseList[position].code.toString() + " " + courseList[position].title.toString()
        holder.name.text = display
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}