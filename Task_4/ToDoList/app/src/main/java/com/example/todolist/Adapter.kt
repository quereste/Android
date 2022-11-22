package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val tasks: List<Task>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTV = itemView.findViewById<TextView>(R.id.task_name)
        val dateTV = itemView.findViewById<TextView>(R.id.task_date)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val taskView = inflater.inflate(R.layout.task, parent, false)
        // Return a new holder instance
        return ViewHolder(taskView)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val task: Task = tasks[position]

        holder.nameTV.text = task.name
        holder.dateTV.text = task.date

    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}