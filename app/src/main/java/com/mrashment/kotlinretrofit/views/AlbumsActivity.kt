package com.mrashment.kotlinretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.mrashment.kotlinretrofit.R

class AlbumsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_posts,menu)
        return true
    }

    fun showAll() {}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.optionAll -> showAll()
            else -> Toast.makeText(this@AlbumsActivity,"Options menu did something whacky", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
