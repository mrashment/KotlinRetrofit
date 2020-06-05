package com.mrashment.kotlinretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.adapters.PostAdapter
import com.mrashment.kotlinretrofit.models.JsonPlaceholderApi
import com.mrashment.kotlinretrofit.models.Post
import com.mrashment.kotlinretrofit.models.User
import com.mrashment.kotlinretrofit.repo.Repository
import kotlinx.android.synthetic.main.activity_posts.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsActivity : AppCompatActivity() {

    val posts: ArrayList<Post> = ArrayList()
    val users: HashMap<Int,User> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        /* Find some way of making this ready for when posts are displayed
        val userCall = Repository.getAllUser()
        userCall.enqueue(object: Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@PostsActivity,"Failed to fetch users",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@PostsActivity,"Failed to fetch users",Toast.LENGTH_SHORT).show()
                    return
                }
                for (u in response.body()!!.iterator()) {
                    users.put(u.id,u)
                }
            }
        })

         */

        sortAscending()

        val recycler= recyclerView
        recycler.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
    }

    fun sortAscending() {
        // Getting the posts to display
        val call = Repository.getPosts(null,"userId","asc")
        call.enqueue(object: Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@PostsActivity,"Failed to retrieve data" + t.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@PostsActivity,"Failed to retrieve data: onResponse" + response.message(),Toast.LENGTH_SHORT).show()
                    return
                }

                posts.clear()
                posts.addAll(response.body()!!)
                recyclerView.adapter = PostAdapter(posts)
            }

        })
    }

    fun sortDescending() {
        // Very strange descending order that may or may not be from the API itself 91 -> 100 -> 81 -> 90 etc
        val call = Repository.getPosts(null,"userId","desc")
        call.enqueue(object: Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@PostsActivity,"Failed to retrieve data" + t.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@PostsActivity,"Failed to retrieve data: onResponse" + response.message(),Toast.LENGTH_SHORT).show()
                    return
                }

                posts.clear()
                posts.addAll(response.body()!!)
                recyclerView.adapter = PostAdapter(posts)
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_posts,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.optionSortAscending -> sortAscending()
            R.id.optionSortDescending -> sortDescending()
            else -> Toast.makeText(this@PostsActivity,"Options menu did something whacky", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
