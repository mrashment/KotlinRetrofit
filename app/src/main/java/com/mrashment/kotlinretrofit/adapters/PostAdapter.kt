package com.mrashment.kotlinretrofit.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.models.Post

class PostAdapter(val posts: ArrayList<Post>): RecyclerView.Adapter<PostAdapter.PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class PostHolder: RecyclerView.ViewHolder() {

    }
}