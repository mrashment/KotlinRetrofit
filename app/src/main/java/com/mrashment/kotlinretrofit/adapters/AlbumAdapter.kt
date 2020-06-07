package com.mrashment.kotlinretrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.models.Album
import kotlinx.android.synthetic.main.layout_album_cardview.view.*
import java.util.zip.Inflater

class AlbumAdapter(val albums: ArrayList<Album>) : RecyclerView.Adapter<AlbumAdapter.AlbumHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        return AlbumHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_album_cardview,parent, false))
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        holder.tvId.text = albums[position].id.toString()
        holder.tvUserId.append(albums[position].userId.toString())
        holder.tvTitle.text = albums[position].title

    }

    class AlbumHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUserId = itemView.tvUserId
        val tvId = itemView.tvId
        val tvTitle = itemView.tvTitle
    }
}