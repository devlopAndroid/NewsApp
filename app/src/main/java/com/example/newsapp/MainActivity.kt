package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }
    private fun getNews() {
        val newslist=findViewById<RecyclerView>(R.id.newslist)
        val newsd = Newsservice.getInstance().create(NewsInterface::class.java)
         val news =newsd.getHeadlines("in")
            news.enqueue(object : Callback<News>
            //synchronously send the request and notify callback of its response or if an error occurred talking to the server,
            // creating the request, or processing the response. Response<T> execute() Synchronously send the request and return its response.
            {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    val news = response.body()
                    if (news != null) {
                        Log.d("Result", news.toString())
                        adapter = NewsAdapter(this@MainActivity, news.articles)
                        newslist.adapter = adapter
                        newslist.layoutManager = LinearLayoutManager(this@MainActivity)

                    }
                }
                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.d("Result", "Error in fetching News")
                }
            })
        }
    }