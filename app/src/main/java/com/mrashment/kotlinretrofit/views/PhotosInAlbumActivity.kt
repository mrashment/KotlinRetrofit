package com.mrashment.kotlinretrofit.views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.adapters.PhotoAdapter
import com.mrashment.kotlinretrofit.models.Album
import com.mrashment.kotlinretrofit.models.Photo
import com.mrashment.kotlinretrofit.repo.Repository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_photos_in_album.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosInAlbumActivity : AppCompatActivity() {
    val TAG: String = "PhotosInAlbumActivity"

    private lateinit var album: Album
    private val photos: ArrayList<Photo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos_in_album)

        Log.d(TAG,"We in there")
        album = intent.getSerializableExtra("album") as Album
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        showPhotos()
    }

    fun showPhotos() {
        Log.d(TAG, "showPhotos" + album.id)
        val call = Repository.getPhotos(album.id.toString())
        call.enqueue(object: Callback<List<Photo>> {
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Toast.makeText(this@PhotosInAlbumActivity,"Failed to retrieve photos", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@PhotosInAlbumActivity,"Failed to retrieve photos", Toast.LENGTH_SHORT).show()
                    return
                }
                photos.addAll(response.body()!!)
                recyclerView.adapter = PhotoAdapter(photos) { photo: Photo -> onThumbnailClicked(photo)}
            }
        })
    }

    fun onThumbnailClicked(photo: Photo) {
        ivFullImage.visibility = View.VISIBLE
        Picasso.get()
            .load(Uri.parse(photo.url))
            .placeholder(R.mipmap.ic_launcher)
            .into(ivFullImage)
    }

    override fun onBackPressed() {
        with (ivFullImage) {
            if (this.visibility == View.VISIBLE) this.visibility = View.GONE
            else super.onBackPressed()
        }
    }
}
