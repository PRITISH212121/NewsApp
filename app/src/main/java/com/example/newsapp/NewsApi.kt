package com.example.newsapp
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=in&apiKey=5399b99102c94d9da204fec422794101
const val BASE_URL="https://newsapi.org/"
const val API_KEY="5399b99102c94d9da204fec422794101"
interface NewsApi {
    @GET("v2/top-headlines?apiKey=${API_KEY}")
    fun getheadlines(@Query ("country")country:String,@Query("page")page :Int):Call<News>
}
object NewsServices{
    var newsinstance:NewsApi
    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsinstance= retrofit.create(NewsApi::class.java)
    }
}