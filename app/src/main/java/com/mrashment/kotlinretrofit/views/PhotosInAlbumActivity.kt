package com.mrashment.kotlinretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.adapters.PhotoAdapter
import com.mrashment.kotlinretrofit.models.Album
import com.mrashment.kotlinretrofit.models.Photo
import com.mrashment.kotlinretrofit.repo.Repository
import kotlinx.android.synthetic.main.activity_photos_in_album.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosInAlbumActivity : AppCompatActivity() {

    private val album: Album = intent.getSerializableExtra("album") as Album
    private val photos: ArrayList<Photo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos_in_album)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        showPhotos()
    }

    fun showPhotos() {
        val call = Repository.getPhotos(album.id)
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
                recyclerView.adapter = PhotoAdapter(photos, {photo: Photo -> Unit})
            }
        })
    }
}
