package com.mrashment.kotlinretrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.models.Album
import kotlinx.android.synthetic.main.layout_album_cardview.view.*
import java.util.zip.Inflater

class AlbumAdapter(val albums: ArrayList<Album>, val albumClickListener: (Album) -> Unit) : RecyclerView.Adapter<AlbumAdapter.AlbumHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        return AlbumHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_album_cardview,parent, false))
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        holder.bind(albums[position], albumClickListener)
    }

    class AlbumHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(album: Album, albumClickListener: (Album) -> Unit) = with(itemView) {
            tvId.text = album.id.toString()
            tvUserId.text = "UserId: ${album.id}"
            tvTitle.text = album.title
            setOnClickListener { albumClickListener(album) }
        }
    }
}