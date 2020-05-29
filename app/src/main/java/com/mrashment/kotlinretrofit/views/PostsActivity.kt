package com.mrashment.kotlinretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.models.Post
import kotlinx.android.synthetic.main.activity_posts.*

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

//        val items = arrayListOf("Some","Simple","Items")
//
//        val listView = listView
//        listView.adapter = ArrayAdapter(this,
//            R.layout.layout_simple_list_item,
//            R.id.tvSimpleItem,items)

        val posts = arrayListOf(Post(1,2,"some title", "some body"),
            Post(2,3,"another title", "another body"))

    }
}
