package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import com.example.newsapp.NewsApi
import com.example.newsapp.News
import retrofit2.Call

import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getnews()
    }
    private fun getnews(){
        val news:Call<News> = NewsServices.newsinstance.getheadlines("in",1)
        news.enqueue(object:Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news:News?=response.body()
                if (news != null) {
                    adapter=Adapter(this@MainActivity, news.articles )
                    val list:RecyclerView= findViewById<RecyclerView>(R.id.newslist)
                    list.adapter=adapter
                    list.layoutManager=LinearLayoutManager(this@MainActivity)
                }
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
            }
        })
    }
}