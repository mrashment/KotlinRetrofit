package com.mrashment.kotlinretrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.models.Post
import kotlinx.android.synthetic.main.layout_post_cardview.view.*

class PostAdapter(val posts: ArrayList<Post>): RecyclerView.Adapter<PostAdapter.PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        return PostHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_post_cardview,parent, false))
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.tvUserId.text = posts[position].id.toString()
        holder.tvTitle.text = posts[position].title
        holder.tvBody.text = posts[position].body
    }

    class PostHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvUserId = itemView.tvUserId
        val tvTitle = itemView.tvTitle
        val tvBody = itemView.tvBody
    }
}