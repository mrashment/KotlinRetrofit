package com.mrashment.kotlinretrofit.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mrashment.kotlinretrofit.R
import com.mrashment.kotlinretrofit.models.Post
import com.mrashment.kotlinretrofit.repo.Repository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

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
        btnPostPost.setOnClickListener {
            CoroutineScope(MainScope().coroutineContext).launch {
                var response: Post? = null
                withContext(Dispatchers.IO) {
                    val call = Repository.postPost(Post(5,4,"A Great Title", "This is the body my dude"))
                    response = call.execute().body()
                }
                Toast.makeText(applicationContext,response?.toString(),Toast.LENGTH_LONG).show()
            }
        }
    }

}
