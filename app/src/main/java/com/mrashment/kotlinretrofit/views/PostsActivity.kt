package com.mrashment.kotlinretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.models.Post
import kotlinx.android.synthetic.main.activity_posts.*

class PostsActivity : AppCompatActivity() {

    val posts: ArrayList<Post> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        val recycler: RecyclerView = findViewById(R.id.recyclerView)
        recycler.adapter =


    }
}
