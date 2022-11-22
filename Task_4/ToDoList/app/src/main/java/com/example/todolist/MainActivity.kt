package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var taskList: ListView = findViewById(R.id.taskList)

        val content = listOf("abc", "finish this task", "finish next task")

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.task, content)

        taskList.adapter = adapter

    }
}