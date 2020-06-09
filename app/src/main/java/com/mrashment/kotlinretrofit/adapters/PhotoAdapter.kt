package com.mrashment.kotlinretrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.models.Photo
import kotlinx.android.synthetic.main.layout_photo_cardview.view.*

class PhotoAdapter(val photos: ArrayList<Photo>, val onClickListener: (Photo) -> Unit): RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        return PhotoHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_photo_cardview,parent,false))
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(photos[position], onClickListener)
    }

    class PhotoHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(photo: Photo, onClickListener: (Photo) -> Unit) {
            itemView.tvId.text = photo.id.toString()
            itemView.tvTitle.text = photo.title
            Glide.with(itemView).load(photo.thumbnailUrl).into(itemView.ivThumbnail)
            itemView.setOnClickListener { onClickListener(photo) }
        }
    }
}