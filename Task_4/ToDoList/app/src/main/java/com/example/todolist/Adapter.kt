package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskBinding

class Adapter(private val tasks: List<Task>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(private val binding: TaskBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.task = task
        }
    }

    private lateinit var binding: TaskBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        binding = TaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val task: Task = tasks[position]

        holder.bind(task)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}