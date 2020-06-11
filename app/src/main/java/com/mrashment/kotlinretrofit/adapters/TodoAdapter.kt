package com.mrashment.kotlinretrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.models.Todo
import kotlinx.android.synthetic.main.layout_todo_cardview.view.*

class TodoAdapter(val todos: ArrayList<Todo>): RecyclerView.Adapter<TodoAdapter.TodoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        return TodoHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_todo_cardview,parent,false))
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.bind(todos[position])
    }

    class TodoHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(todo: Todo) = with(itemView) {
            tvId.text = todo.id.toString()
            tvTitle.text = todo.title
            tvFinished.text = if(todo.completed) "Done" else "Not done"
        }
    }
}