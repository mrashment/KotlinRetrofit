package com.mrashment.kotlinretrofit.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrashment.kotlinretrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupButtons()
    }

    private fun setupButtons() {
        btnPosts.setOnClickListener {
            val intent = Intent(this,
                PostsActivity::class.java)
            startActivity(intent)
        }
        btnAlbums.setOnClickListener {
            val intent = Intent(this,
                AlbumsActivity::class.java)
            startActivity(intent)
        }
        btnTodos.setOnClickListener {
            val intent = Intent(this,
                TodosActivity::class.java)
            startActivity(intent)
        }
    }

}
