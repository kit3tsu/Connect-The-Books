package be.bf.kit3tsu.connect_the_books.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBookApi {
    @GET
    suspend fun getBookData(@Query("isbn") isbn : Float)

}