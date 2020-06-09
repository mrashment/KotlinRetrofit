package com.mrashment.kotlinretrofit.adapters

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.models.Photo
import kotlinx.android.synthetic.main.layout_photo_cardview.view.*
import java.net.URL

class PhotoAdapter(val photos: ArrayList<Photo>, val photoClickListener: (Photo) -> Unit): RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        return PhotoHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_photo_cardview,parent,false))
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(photos[position], photoClickListener)
    }

    class PhotoHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val TAG = "PhotoHolder"

        fun bind(photo: Photo, photoClickListener: (Photo) -> Unit) {
            itemView.tvId.text = photo.id.toString()
            itemView.tvTitle.text = photo.title
            Log.d(TAG,photo.thumbnailUrl)
            Glide.with(itemView)
                .load(Uri.parse(photo.thumbnailUrl))
                .placeholder(R.mipmap.ic_launcher)
                .into(itemView.ivThumbnail)
            itemView.setOnClickListener { photoClickListener(photo)}
        }
    }
}