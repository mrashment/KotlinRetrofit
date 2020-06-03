package com.mrashment.kotlinretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.adapters.PostAdapter
import com.mrashment.kotlinretrofit.models.JsonPlaceholderApi
import com.mrashment.kotlinretrofit.models.Post
import com.mrashment.kotlinretrofit.repo.Repository
import kotlinx.android.synthetic.main.activity_posts.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsActivity : AppCompatActivity() {

    val posts: ArrayList<Post> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)



        val call = Repository.getAllPosts()
        call.enqueue(object: Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@PostsActivity,"Failed to retrieve data" + t.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@PostsActivity,"Failed to retrieve data: onResponse" + response.message(),Toast.LENGTH_SHORT).show()
                    return
                }

                for (p in response.body()!!.iterator()) {
                    posts.add(p)
                }
                recyclerView.adapter = PostAdapter(posts)
            }

        })

        val recycler= recyclerView
        recycler.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        recycler.adapter = PostAdapter(posts)


    }
}
