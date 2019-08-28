package chikani.marycarmen.urbandictionary.api

import chikani.marycarmen.urbandictionary.model.Definition
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DictionaryApi {


    @Headers(
        "X-RapidAPI-Host:mashape-community-urban-dictionary.p.rapidapi.com",
        "X-RapidAPI-Key:9ee2d8a679msh1a307350ccb4f0cp1d10b3jsn46e51c0d4ec2"
    )
    @GET("define")


    fun getCurrentWordData(@Query("term") term: String): Deferred<Definition>


    companion object {
        fun create(): DictionaryApi {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl("https://mashape-community-urban-dictionary.p.rapidapi.com/")
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(DictionaryApi::class.java)
        }
    }

}