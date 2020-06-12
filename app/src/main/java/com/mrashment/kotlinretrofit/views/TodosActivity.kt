package com.mrashment.kotlinretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.models.Todo
import com.mrashment.kotlinretrofit.models.User
import com.mrashment.kotlinretrofit.repo.Repository
import kotlinx.android.synthetic.main.activity_albums.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class TodosActivity : AppCompatActivity() {

    val todos: ArrayList<Todo> = ArrayList()
    val users: ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        recyclerView.layoutManager = LinearLayoutManager(this@TodosActivity,RecyclerView.VERTICAL,false)

        getUsers()
    }

    fun getUsers() {
        val call = Repository.getAllUsers()
        call.enqueue(object: Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@TodosActivity,"Failed to retrieve users",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@TodosActivity,"Failed to retrieve users",Toast.LENGTH_SHORT).show()
                    return
                }
                users.clear()
                users.addAll(response.body()!!)

            }
        })
    }
}
