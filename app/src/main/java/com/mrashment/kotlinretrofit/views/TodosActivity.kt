package com.mrashment.kotlinretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.adapters.TodoAdapter
import com.mrashment.kotlinretrofit.models.Todo
import com.mrashment.kotlinretrofit.models.User
import com.mrashment.kotlinretrofit.repo.Repository
import kotlinx.android.synthetic.main.activity_albums.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class TodosActivity : AppCompatActivity() {

    val scope = CoroutineScope(Job() + Dispatchers.Main)
    val todos: ArrayList<Todo> = ArrayList()
    val users: MutableMap<Int, User> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        recyclerView.layoutManager = LinearLayoutManager(this@TodosActivity,RecyclerView.VERTICAL,false)

        val job = scope.async {
            getUsers()
            getTodos()
            recyclerView.adapter = TodoAdapter(users,todos)
        }
    }

    suspend fun getUsers() {
        withContext(Dispatchers.IO) {
            val call = Repository.getAllUsers()
            val response = call.execute()
            if (!response.isSuccessful) {
                Toast.makeText(this@TodosActivity,"Failed to retrieve users",Toast.LENGTH_SHORT).show()
                return@withContext
            }

            for (user in response.body()!!) {
                users[user.id] = user
            }
        }
    }

    suspend fun getTodos(userId: Int? = null) {
        withContext(Dispatchers.IO) {
            val call = Repository.getTodos(userId)
            val response = call.execute()
            if (!response.isSuccessful) {
                Toast.makeText(this@TodosActivity, "Failed to retrieve todos", Toast.LENGTH_SHORT)
                    .show()
                return@withContext
            }
            todos.clear()
            todos.addAll(response.body()!!)
        }
    }
}
