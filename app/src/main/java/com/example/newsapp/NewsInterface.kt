package com.example.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query



const val Base_Url = "https://newsapi.org/"
const val ApiKey = "f5f763053d324cf8a8dd701ef0bdd432"
interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$ApiKey")
    fun getHeadlines(@Query("country") country:String) : Call<News>

}
object Newsservice{

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}
