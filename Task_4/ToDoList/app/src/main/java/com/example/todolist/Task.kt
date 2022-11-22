package com.example.todolist

data class Task(val name: String, val description: String, val date: String, val status: String) {
    companion object {
        fun createTasks() : ArrayList<Task> {
            val tasks = ArrayList<Task>()

            tasks.add(Task("Task1", "Description", "Tomorrow", "ToDo"));
            tasks.add(Task("Task2", "Description", "Tomorrow", "ToDo"));
            tasks.add(Task("Task3", "Description", "Tomorrow", "ToDo"));
            tasks.add(Task("Task4", "Description", "Tomorrow", "ToDo"));
            tasks.add(Task("Task5", "Description", "Tomorrow", "ToDo"));
            tasks.add(Task("Task6", "Description", "Tomorrow", "ToDo"));

            return tasks;
        }
    }
}

