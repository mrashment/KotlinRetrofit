package com.mrashment.kotlinretrofit.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.adapters.AlbumAdapter
import com.mrashment.kotlinretrofit.models.Album
import com.mrashment.kotlinretrofit.repo.Repository
import kotlinx.android.synthetic.main.activity_albums.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumsActivity : AppCompatActivity() {

    val albums: ArrayList<Album> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        recyclerView.layoutManager = LinearLayoutManager(this@AlbumsActivity,LinearLayoutManager.VERTICAL,false)
        showAll()
    }

    fun albumClicked(album: Album) {
        val intent = Intent(this@AlbumsActivity, PhotosInAlbumActivity::class.java)
        intent.putExtra("album",album)
        startActivity(intent)
    }

    private fun showAll() {
        val call = Repository.getAllAlbums()
        call.enqueue(object: Callback<List<Album>> {
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                Toast.makeText(this@AlbumsActivity,"Failed to retrieve albums",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@AlbumsActivity,"Failed to retrieve albums",Toast.LENGTH_SHORT).show()
                    return
                }
                albums.clear()
                albums.addAll(response.body()!!)
                recyclerView.adapter = AlbumAdapter(albums) { album: Album -> albumClicked(album)}
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_albums,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.optionAll -> showAll()
            else -> Toast.makeText(this@AlbumsActivity,"Options menu did something whacky", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
